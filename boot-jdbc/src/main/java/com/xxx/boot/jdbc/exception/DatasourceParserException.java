package com.xxx.boot.jdbc.exception;

/**
 * Date: 2015-09-25
 *
 * @author luoxiaoyong
 */
public class DatasourceParserException extends RuntimeException{
    public DatasourceParserException() {
        super();
    }

    public DatasourceParserException(String message) {
        super(message);
    }

    public DatasourceParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
