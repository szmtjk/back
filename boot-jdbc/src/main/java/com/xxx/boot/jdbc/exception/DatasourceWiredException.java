package com.xxx.boot.jdbc.exception;

/**
 * Date: 2015-09-28
 *
 * @author luoxiaoyong
 */
public class DatasourceWiredException extends RuntimeException{
    public DatasourceWiredException(String message) {
        super(message);
    }

    public DatasourceWiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
