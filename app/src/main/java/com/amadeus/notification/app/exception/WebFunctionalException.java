package com.amadeus.notification.app.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.http.HttpStatus;

import com.amadeus.notification.domain.exception.FunctionalException;

/**
 * Exception fonctionnelle
 */
public class WebFunctionalException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String code;
    private final Map<String, Object> contextParams = new HashMap<>();

    public WebFunctionalException(HttpStatus httpStatus, String code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public WebFunctionalException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public WebFunctionalException(String code, String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public WebFunctionalException(String code, Throwable cause, HttpStatus httpStatus) {
        super(cause);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public WebFunctionalException(String code, String message, Map<String, Object> contextParams, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
        if (contextParams != null){
            this.contextParams.putAll(contextParams);
        }
    }

    public WebFunctionalException(String code, String message, Map<String, Object> contextParams, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.code = code;
        this.httpStatus = httpStatus;
        if (contextParams != null) {
            this.contextParams.putAll(contextParams);
        }
    }

    public WebFunctionalException(FunctionalException functionalException, final HttpStatus httpStatus) {
        super(functionalException.getMessage(),functionalException.getCause());
        this.code = functionalException.getCode();
        if(functionalException.getContextParams() != null) {
            this.contextParams.putAll(functionalException.getContextParams());
        }
        this.httpStatus = httpStatus;
    }

    public WebFunctionalException(NotificationExceptionResponse exceptionResponse, final HttpStatus httpStatus) {
        super(exceptionResponse.getMessage());
        this.code = exceptionResponse.getCode();
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    public Map<String, Object> getContextParams() {
        return this.contextParams;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WebFunctionalException.class.getSimpleName() + "[", "]").add("httpStatus=" + httpStatus)
                                                                                              .add("code='" + code + "'")
                                                                                              .add("contextParams=" + contextParams)
                                                                                              .toString();
    }
}
