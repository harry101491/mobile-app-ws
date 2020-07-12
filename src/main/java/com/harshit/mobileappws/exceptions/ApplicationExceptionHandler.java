package com.harshit.mobileappws.exceptions;

import com.harshit.mobileappws.exceptions.user.UserServiceException;
import com.harshit.mobileappws.model.response.CustomErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     *  The value Exception Class specifies what types of exceptions it can handle
     *  So if it can handle Exception or Null pointer exception it should be provided
     *  in the value and in argument list as well.
     *  Note: function name can be anything the important part is to have it annotated with ExceptionHandler
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest wr) {
        // creating a custom exception object
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(
                new Date(),
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : ex.toString()
        );
        return new ResponseEntity<>(customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest wr) {
        // creating a custom exception object
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(
                new Date(),
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : ex.toString()
        );
        return new ResponseEntity<>(customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest wr) {
        // creating a custom exception object
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(
                new Date(),
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : ex.toString()
        );
        return new ResponseEntity<>(customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
