package com.zap.devil.catalog.exceptions;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CatalogException extends RuntimeException {
    private static final long serialVersionUID = 3266235542893712987L;

    public CatalogException(String message) {
        super(message);
    }

    public CatalogException(Throwable cause) {
        super(cause);
    }

    public CatalogException(String message, Throwable cause) {
        super(message, cause);
    }


}
