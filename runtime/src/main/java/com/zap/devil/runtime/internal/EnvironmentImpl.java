package com.zap.devil.runtime.internal;

import com.zap.devil.catalog.CatalogManager;
import com.zap.devil.catalog.GenericInMemoryCatalog;
import com.zap.devil.delegation.Executor;
import com.zap.devil.delegation.ExecutorFactory;
import com.zap.devil.delegation.Parser;
import com.zap.devil.delegation.Planner;
import com.zap.devil.delegation.PlannerFactory;
import com.zap.devil.factories.ComponentFactoryService;
import com.zap.devil.opertions.Operation;
import com.zap.devil.opertions.ShowDatabasesOperation;
import com.zap.devil.runtime.Environment;
import com.zap.devil.runtime.EnvironmentSettings;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class EnvironmentImpl implements Environment {

    private final CatalogManager catalogManager;
    protected final Parser parser;

    public EnvironmentImpl(CatalogManager catalogManager,
                           Executor executor,
                           Planner planner) {
        this.catalogManager = catalogManager;

        this.parser = planner.getParser();
    }

    public static EnvironmentImpl create(EnvironmentSettings settings) {
        // 创建catalogManager
        CatalogManager catalogManager =
                CatalogManager.newBuilder()
                        .defaultCatalog(
                                settings.getBuiltInCatalogName(),
                                new GenericInMemoryCatalog(
                                        settings.getBuiltInCatalogName(),
                                        settings.getBuiltInDatabaseName()))
                        .build();

        ExecutorFactory executorFactory = ComponentFactoryService.find(ExecutorFactory.EXECUTOR_NAME);
        Executor executor = executorFactory.create();

        PlannerFactory plannerFactory = ComponentFactoryService.find(PlannerFactory.PLANNER_NAME);
        Planner planner = plannerFactory.create(executor, catalogManager);

        return new EnvironmentImpl(catalogManager, executor, planner);
    }

    /**
     * 执行SQL
     */
    public void executeSql(String query) {
        List<Operation> operations = parser.parse(query);
        if (operations.size() != 1) {
            throw new IllegalStateException("一次只能执行一条sql语句");
        }

        // 执行operation
        executeOperation(operations.get(0));
    }

    /**
     * 执行operation
     */
    private void executeOperation(Operation operation) {
        if (operation instanceof ShowDatabasesOperation) {
            buildShowResult("database name", listDatabases());
        }
    }

    /**
     * 输出结果
     */
    private void buildShowResult(String columnName, String[] objects) {
        System.out.println(columnName);
        for (String object : objects) {
            System.out.println(object);
        }
    }

    private String[] listDatabases() {
        return catalogManager.getCatalog(catalogManager.getCurrentCatalog())
                .get()
                .listDatabases()
                .toArray(new String[0]);
    }

}
