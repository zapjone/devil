package com.zap.devil.catalog.exceptions;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CatalogNotExistException extends RuntimeException {

    private static final long serialVersionUID = -2586018452550501186L;

    public CatalogNotExistException(String catalogName) {
        this(catalogName, null);
    }

    public CatalogNotExistException(String catalogName, Throwable cause) {
        super("Catalog " + catalogName + " does not exist.", cause);
    }
}
