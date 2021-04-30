package com.zap.devil.catalog.exceptions;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class DatabaseNotExistException extends Exception {

    private static final long serialVersionUID = 6464655306054687105L;
    private static final String MSG = "Database %s does not exist in Catalog %s.";

    public DatabaseNotExistException(String catalogName, String databaseName, Throwable cause) {
        super(String.format(MSG, databaseName, catalogName), cause);
    }

    public DatabaseNotExistException(String catalogName, String databaseName) {
        this(catalogName, databaseName, null);
    }


}
