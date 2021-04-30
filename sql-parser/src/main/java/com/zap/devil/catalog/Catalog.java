package com.zap.devil.catalog;

import com.zap.devil.ObjectPath;
import com.zap.devil.catalog.exceptions.CatalogException;
import com.zap.devil.catalog.exceptions.DatabaseNotExistException;

import java.util.List;

/**
 * Catalog的接口
 *
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public interface Catalog {


    void open() throws CatalogException;


    void close() throws CatalogException;


    String getDefaultDatabase() throws CatalogException;


    List<String> listDatabases() throws CatalogException;

    boolean databaseExists(String databaseName) throws CatalogException;

    List<String> listTables(String databaseName) throws DatabaseNotExistException, CatalogException;


    boolean tableExists(ObjectPath tablePath) throws CatalogException;

}
