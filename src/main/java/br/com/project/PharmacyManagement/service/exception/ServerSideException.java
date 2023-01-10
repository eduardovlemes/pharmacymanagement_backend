package br.com.project.PharmacyManagement.service.exception;

public class ServerSideException extends RuntimeException{

    public ServerSideException (String message) {
        super(message);
    }

    public ServerSideException(){
        super();
    }
}
