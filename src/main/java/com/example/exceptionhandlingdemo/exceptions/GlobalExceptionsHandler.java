package com.example.exceptionhandlingdemo.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFound ex, WebRequest req){
        ErrorDetails error = new ErrorDetails(ex.getMessage(),404,new Date());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDetails> handleResponseStatusException(ResponseStatusException ex,WebRequest req) {
        ErrorDetails error = new ErrorDetails("Record Not Found",404,new Date());
         return new ResponseEntity<ErrorDetails> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> handleSQLException(NullPointerException ex, WebRequest request){
        ErrorDetails error = new ErrorDetails(ex.getMessage(), 500,new Date());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDetails> handleSQLException(SQLException ex,WebRequest request){
        ErrorDetails error = new ErrorDetails(ex.getMessage(), 500,new Date());
        return new ResponseEntity<ErrorDetails>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(ResourceHttpRequestHandler.)
//    public ResponseEntity<ErrorDetails> handleInsufficientAuthenticationException(InsufficientAuthenticationException ex,WebRequest request){
//        ErrorDetails error = new ErrorDetails("It's an unauthorized request",401,new Date());
//        return  new ResponseEntity<ErrorDetails> (error,HttpStatus.UNAUTHORIZED);
//    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDetails> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,WebRequest req){
        ErrorDetails error = new ErrorDetails("It's an Invalid or illegal Request.Please,Check the uri path",400,new Date());
        return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler(ExceptionHandlerExceptionResolver.class)
//    public ResponseEntity<ErrorDetails> handlerExceptionHandlerExceptionResolver(MethodArgumentTypeMismatchException ex, WebRequest req) {
//        ErrorDetails error = new ErrorDetails("It's an Invalid Request", 406, new Date());
//        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDetails> handleIOException(IOException ex,WebRequest req){
        ErrorDetails error = new ErrorDetails(ex.getMessage(), 501,new Date());
        return new ResponseEntity<ErrorDetails>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported
            (HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
             WebRequest request) {
        return new ResponseEntity<Object> ("The Request method type is not allowed.Please change it",
                HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Something Went wrong",HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDetails> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), 502,new Date());
        return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleExceptionclass(Exception ex, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),503,new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
