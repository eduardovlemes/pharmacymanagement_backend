package br.com.project.PharmacyManagement.service.exception;

public class BadRequestException extends RuntimeException {

    BadRequestException(String message){
        super(message);
    }

    BadRequestException(){
        super();
    }
}
