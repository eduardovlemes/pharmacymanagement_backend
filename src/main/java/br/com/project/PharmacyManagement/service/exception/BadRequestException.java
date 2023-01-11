package br.com.project.PharmacyManagement.service.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }

    BadRequestException(){
        super();
    }
}
