package com.example.baseTemplate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  自定义异常
 */
@Getter
@AllArgsConstructor
public class RuntimeApiException extends RuntimeException {
    private static final long serialVersionUID = -1807640433323748072L;

    private String code;
    private String message;
    private String arg;

    public RuntimeApiException(String code) {
        this.code = code;
    }

    public RuntimeApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
