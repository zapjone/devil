package com.zap.devil.catalog.exceptions;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = -2082275573115478881L;

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }
}
