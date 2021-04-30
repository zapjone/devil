package com.zap.devil.catalog;

import com.zap.devil.ObjectPath;
import com.zap.devil.catalog.exceptions.CatalogException;
import com.zap.devil.catalog.exceptions.DatabaseNotExistException;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class GenericInMemoryCatalog extends AbstractCatalog {

    public static final String DEFAULT_DB = "default";

    private final Map<String, CatalogDatabase> databases;
    private final Map<ObjectPath, CatalogBaseTable> tables;

    public GenericInMemoryCatalog(String name, String defaultDatabase) {
        super(name, defaultDatabase);

        this.databases = new LinkedHashMap<>();
        this.databases.put(defaultDatabase, new CatalogDatabaseImpl(new HashMap<>(), null));
        this.tables = new LinkedHashMap<>();
    }

    @Override
    public void open() throws CatalogException {
    }

    @Override
    public void close() throws CatalogException {

    }

    @Override
    public List<String> listDatabases() throws CatalogException {
        return Collections.emptyList();
    }

    @Override
    public boolean databaseExists(String databaseName) throws CatalogException {
        return false;
    }

    @Override
    public List<String> listTables(String databaseName) throws DatabaseNotExistException, CatalogException {
        return null;
    }

    @Override
    public boolean tableExists(ObjectPath tablePath) throws CatalogException {
        return false;
    }
}
