package com.zap.devil.catalog;

import java.util.Map;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CatalogDatabaseImpl implements CatalogDatabase {

    private final String comment;

    public CatalogDatabaseImpl(Map<String, String> properties, String comment) {
        this.comment = comment;
    }

    @Override
    public String getComment() {
        return comment;
    }

}
