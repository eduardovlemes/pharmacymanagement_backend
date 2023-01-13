package br.com.project.PharmacyManagement.controller.handler;

import br.com.project.PharmacyManagement.DTO.DefaultErrorResponse.DefaultErrorResponse;
import br.com.project.PharmacyManagement.service.exception.BadRequestException;
import br.com.project.PharmacyManagement.service.exception.NotFoundException;
import br.com.project.PharmacyManagement.service.exception.ServerSideException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity  treatNotFoundException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        e.getCause()),
                        HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity treatBadRequestException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage(),
                        e.getCause()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerSideException.class)
    public ResponseEntity treatServerSideException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getMessage(),
                        e.getCause()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity treatMethodArgumentNotValidException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage(),
                        e.getCause()
                ),
                HttpStatus.BAD_REQUEST);
    }
}
