package com.zap.devil.runtime;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class EnvironmentSettings {

    private final String builtInCatalogName;

    private final String builtInDatabaseName;

    public EnvironmentSettings(
            String builtInCatalogName,
            String builtInDatabaseName) {
        this.builtInCatalogName = builtInCatalogName;
        this.builtInDatabaseName = builtInDatabaseName;
    }

    public String getBuiltInCatalogName() {
        return builtInCatalogName;
    }

    public String getBuiltInDatabaseName() {
        return builtInDatabaseName;
    }

}
