package com.zap.devil.delegation;

import com.zap.devil.api.Transformation;
import com.zap.devil.catalog.CatalogManager;
import com.zap.devil.catalog.CatalogManagerCalciteSchema;
import com.zap.devil.opertions.Operation;

import java.util.List;

import static org.apache.calcite.jdbc.CalciteSchemaBuilder.asRootSchema;

/**
 * DevilPlanner
 *
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class DevilPlanner implements Planner {

    private final Parser parser;

    public DevilPlanner(Executor executor, CatalogManager catalogManager) {
        // 创建解析器
        this.parser = DevilParser.create(asRootSchema(new CatalogManagerCalciteSchema(catalogManager)),
                catalogManager);
    }

    @Override
    public Parser getParser() {
        return this.parser;
    }

    @Override
    public List<Transformation<?>> translate(List<Operation> operations) {
        System.out.println("operation转换成transformation");
        return null;
    }
}
