package com.zap.devil.catalog;

import com.zap.devil.catalog.exceptions.CatalogException;
import com.zap.devil.catalog.exceptions.CatalogNotExistException;
import com.zap.devil.catalog.exceptions.DatabaseNotExistException;
import com.zap.devil.catalog.exceptions.ValidationException;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;

/**
 * Devil catalog管理
 *
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CatalogManager {

    /**
     * 保存所有的catalog
     */
    private final Map<String, Catalog> catalogs;

    /**
     * 当前的catalog名称
     */
    private String currentCatalogName;

    /**
     * 当前数据库名称
     */
    private String currentDatabaseName;

    private CatalogManager(String defaultCatalogName, Catalog defaultCatalog) {
        catalogs = new LinkedHashMap<>();
        catalogs.put(defaultCatalogName, defaultCatalog);
        currentCatalogName = defaultCatalogName;
        currentDatabaseName = defaultCatalog.getDefaultDatabase();
    }


    public static Builder newBuilder() {
        return new Builder();
    }


    /**
     * Builder for a fluent definition of a {@link CatalogManager}.
     */
    public static final class Builder {

        private String defaultCatalogName;

        private Catalog defaultCatalog;

        public Builder defaultCatalog(String defaultCatalogName, Catalog defaultCatalog) {
            this.defaultCatalogName = defaultCatalogName;
            this.defaultCatalog = defaultCatalog;
            return this;
        }

        public CatalogManager build() {
            return new CatalogManager(
                    defaultCatalogName,
                    defaultCatalog);
        }
    }

    /**
     * 注册新的catalog
     *
     * @param catalogName catalog名称
     * @param catalog     catalog实现
     */
    public void registerCatalog(String catalogName, Catalog catalog) {
        if (catalogs.containsKey(catalogName)) {
            throw new CatalogException(format("Catalog %s already exists.", catalogName));
        }

        catalog.open();
        catalogs.put(catalogName, catalog);
    }

    /**
     * 卸载catalog
     *
     * @param catalogName       catalog名称
     * @param ignoreIfNotExists 是否忽略不存在的catalog，如果不忽略，不存在时将抛出异常
     */
    public void unregisterCatalog(String catalogName, boolean ignoreIfNotExists) {
        if (catalogs.containsKey(catalogName)) {
            Catalog catalog = catalogs.remove(catalogName);
            catalog.close();
        } else if (!ignoreIfNotExists) {
            throw new CatalogException(format("Catalog %s does not exist.", catalogName));
        }
    }

    /**
     * 获取catalog
     *
     * @param catalogName catalog名称
     * @return 获取到的catalog，可能为空
     */
    public Optional<Catalog> getCatalog(String catalogName) {
        return Optional.ofNullable(catalogs.get(catalogName));
    }

    /**
     * 获取当前catalog名称
     *
     * @return 当前catalog的名称
     */
    public String getCurrentCatalog() {
        return currentCatalogName;
    }

    /**
     * 设置当前的catalog
     *
     * @param catalogName catalog名称
     * @throws CatalogNotExistException 不存在catalog将抛出异常
     */
    public void setCurrentCatalog(String catalogName) throws CatalogNotExistException {
        Catalog potentialCurrentCatalog = catalogs.get(catalogName);
        if (potentialCurrentCatalog == null) {
            throw new CatalogException(
                    format("A catalog with name [%s] does not exist.", catalogName));
        }

        if (!currentCatalogName.equals(catalogName)) {
            currentCatalogName = catalogName;
            currentDatabaseName = potentialCurrentCatalog.getDefaultDatabase();
        }
    }

    /**
     * 获取当前数据库
     *
     * @return 当前数据库名称
     */
    public String getCurrentDatabase() {
        return currentDatabaseName;
    }

    /**
     * 获取当前数据库下的所有表
     *
     * @return 表名称列表
     */
    public Set<String> listTables() {
        return listTables(getCurrentCatalog(), getCurrentDatabase());
    }

    public Set<String> listTables(String catalogName, String databaseName) {
        Catalog currentCatalog = catalogs.get(getCurrentCatalog());
        try {
            return new HashSet<>(currentCatalog.listTables(getCurrentDatabase()));
        } catch (DatabaseNotExistException e) {
            throw new ValidationException("Current database does not exist", e);
        }
    }
}
