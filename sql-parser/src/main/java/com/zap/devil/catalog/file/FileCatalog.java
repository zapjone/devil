package com.zap.devil.catalog.file;

import com.zap.devil.ObjectPath;
import com.zap.devil.catalog.AbstractCatalog;
import com.zap.devil.catalog.exceptions.CatalogException;
import com.zap.devil.catalog.exceptions.DatabaseNotExistException;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于文件的catalog
 *
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class FileCatalog extends AbstractCatalog {

    public FileCatalog(String name, String defaultDatabase) {
        super(name, defaultDatabase);
    }

    @Override
    public void open() throws CatalogException {
        System.out.println("file open");
    }

    @Override
    public void close() throws CatalogException {
        System.out.println("file close");
    }

    @Override
    public List<String> listDatabases() throws CatalogException {
        System.out.println("file listDatabases");
        return new ArrayList<>();
    }

    @Override
    public boolean databaseExists(String databaseName) throws CatalogException {
        System.out.println("file databaseExists");
        return true;
    }

    @Override
    public List<String> listTables(String databaseName) throws CatalogException {
        System.out.println("file listTables");
        return new ArrayList<>();
    }

    @Override
    public boolean tableExists(ObjectPath tablePath) throws CatalogException {
        System.out.println("file tableExists");
        return true;
    }
}
