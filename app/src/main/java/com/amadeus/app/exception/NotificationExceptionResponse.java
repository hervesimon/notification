package com.amadeus.app.exception;

import org.springframework.http.HttpStatus;

import com.amadeus.domain.exception.FunctionalException;

/**
 *
 * La structure de la réponse HTTP quand une exception est levée
 */
public class NotificationExceptionResponse {

    /**
     * code du message
     */
    private String code;

    /**
     * contenu du message
     */
    private String message;

    public NotificationExceptionResponse() {
    }

    public NotificationExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static final NotificationExceptionResponse fromFunctionException(FunctionalException fexp) {
        return new NotificationExceptionResponse(fexp.getCode(), fexp.getMessage());
    }

    public enum CODES {
        UNEXPECTED("error.unexpected", "erreur inattendue", HttpStatus.INTERNAL_SERVER_ERROR),
        GLOBAL_EXCEPTION("error.globalexception", "erreur interne inattendue", HttpStatus.INTERNAL_SERVER_ERROR),
        METHOD_NOT_SUPPORTED("error.method_not_supported", "méthode non supportée", HttpStatus.METHOD_NOT_ALLOWED),
        NO_HANDLE_FOUND("error.no_handle_found", "handle non trouvé", HttpStatus.NOT_FOUND),
        BAD_REQUEST("error.bad_request", "Mauvaise requête", HttpStatus.BAD_REQUEST),
        UNAUTHORIZED("error.no_handle_found", "Accès non autorisé", HttpStatus.UNAUTHORIZED);

        /**
         * Code identifiant le message
         */
        private final String code;

        /**
         * contenu du message
         */
        private final String message;

        /**
         * statut http
         */
        private final HttpStatus httpStatus;

        CODES(String code, String defaultMessage, HttpStatus httpStatus) {
            this.code = code;
            this.message = defaultMessage;
            this.httpStatus = httpStatus;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }

    }

}
