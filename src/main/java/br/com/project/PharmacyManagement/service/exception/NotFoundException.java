package br.com.project.PharmacyManagement.service.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(){
        super();
    }
}
