package com.zap.devil.catalog;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public abstract class AbstractCatalog implements Catalog {
    private final String catalogName;
    private final String defaultDatabase;

    public AbstractCatalog(String name, String defaultDatabase) {
        this.catalogName = name;
        this.defaultDatabase = defaultDatabase;
    }


    public String getName() {
        return catalogName;
    }

    @Override
    public String getDefaultDatabase() {
        return defaultDatabase;
    }

}
