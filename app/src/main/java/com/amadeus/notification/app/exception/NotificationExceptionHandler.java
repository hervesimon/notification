package com.amadeus.notification.app.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.amadeus.notification.domain.exception.TechnicalException;

/**
 * Gestion des exceptions de l'application
 */
@ControllerAdvice
public class NotificationExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger _LOGGER = LoggerFactory.getLogger(NotificationExceptionHandler.class);
    protected static HttpHeaders httpHeader;

    static {
        httpHeader = new HttpHeaders();
        httpHeader.add("content-type", "application/json;charset=UTF-8");
    }

    private NotificationExceptionResponse buildResponse(String code, String message) {
        return new NotificationExceptionResponse(code, message);
    }

    /**
     * Traite les runtimeexceptions
     *
     * @param e the runtimeexception
     * @param request
     *
     * @return
     */
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e, WebRequest request) {
        // Toutes les erreurs internes du serveur sont tracées
        if (_LOGGER.isErrorEnabled()) {
            _LOGGER.error("Une erreur technique interne non gérée s'est produite exception", e);
        }
        return new ResponseEntity<>(this.buildResponse(NotificationExceptionResponse.CODES.UNEXPECTED.getCode(), NotificationExceptionResponse.CODES.UNEXPECTED.getMessage()),
                NotificationExceptionResponse.CODES.UNEXPECTED.getHttpStatus());
    }

    /**
     * Traite les runtimeexceptions
     *
     * @param e the runtimeexception
     * @param request
     *
     * @return
     */
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleGlobalException(Exception e, WebRequest request) {
        // Toutes les erreurs internes du serveur sont tracées
        if (_LOGGER.isWarnEnabled()) {
            _LOGGER.warn("Une erreur exception non runtime interne non gérée s'est produite exception", e);
        }
        return new ResponseEntity<>(
                this.buildResponse(NotificationExceptionResponse.CODES.GLOBAL_EXCEPTION.getCode(), NotificationExceptionResponse.CODES.GLOBAL_EXCEPTION.getMessage()),
                NotificationExceptionResponse.CODES.GLOBAL_EXCEPTION.getHttpStatus());
    }

    /**
     * Traite les TechnicalException
     *
     * @param e
     * @param request
     *
     * @return
     */
    @ExceptionHandler({ TechnicalException.class })
    public ResponseEntity<Object> handleTechnicalException(TechnicalException e, WebRequest request) {
        // Toutes les erreurs internes du serveur sont tracées
        if (_LOGGER.isErrorEnabled()) {
            _LOGGER.error("Une erreur technique interne s'est produite exception", e);
        }
        NotificationExceptionResponse response = this.buildResponse(e.getCode(), e.getMessage());
        return new ResponseEntity<>(response, NotificationExceptionResponse.CODES.UNEXPECTED.getHttpStatus());
    }

    /**
     * Traite les TechnicalException
     *
     * @param e
     * @param request
     *
     * @return
     */
    @ExceptionHandler({ WebFunctionalException.class })
    public ResponseEntity<Object> handleFunctionalException(WebFunctionalException e, WebRequest request) {
        // Toutes les erreurs internes du serveur sont tracées
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("Une erreur technique interne s'est produite exception", e);
        }
        NotificationExceptionResponse response = this.buildResponse(e.getCode(), e.getMessage());
        return new ResponseEntity<>(response, NotificationExceptionResponse.CODES.UNEXPECTED.getHttpStatus());
    }

    // Méthode qui gère les exceptions de type "MethodArgumentNotValidException"
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        final List<NotificationExceptionResponse> responses = new ArrayList<>();
        // On parcourt toutes les erreurs
        for (final FieldError error : e.getBindingResult().getFieldErrors()) {
            _LOGGER.debug("FieldError : {} :: {} : {}", error.getCode(), error.getField(), error.getDefaultMessage());
            responses.add(new NotificationExceptionResponse(error.getCode(), error.getDefaultMessage()));
        }
        for (final ObjectError error : e.getBindingResult().getGlobalErrors()) {
            _LOGGER.debug("ObjectError : {} :: {} : {}", error.getCode(), error.getObjectName(), error.getDefaultMessage());
            responses.add(new NotificationExceptionResponse(error.getCode(), error.getDefaultMessage()));
        }
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("handleMethodArgumentNotValid exception", e);
        }
        return handleExceptionInternal(e, responses, httpHeader, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String[] ltSupported = exception.getSupportedMethods();
        NotificationExceptionResponse response =
                this.buildResponse(NotificationExceptionResponse.CODES.METHOD_NOT_SUPPORTED.getCode(), NotificationExceptionResponse.CODES.METHOD_NOT_SUPPORTED.getMessage());

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("handleMethodArgumentNotValid exception", exception);
        }
        return new ResponseEntity<>(response, NotificationExceptionResponse.CODES.METHOD_NOT_SUPPORTED.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("handleNoHandlerFoundException exception", exception);
        }
        NotificationExceptionResponse response =
                this.buildResponse(NotificationExceptionResponse.CODES.NO_HANDLE_FOUND.getCode(), NotificationExceptionResponse.CODES.NO_HANDLE_FOUND.getMessage());

        return new ResponseEntity<>(response, NotificationExceptionResponse.CODES.NO_HANDLE_FOUND.getHttpStatus());
    }

}
