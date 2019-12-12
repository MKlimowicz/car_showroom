package pl.mk.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Client with this same pesel exists")
public class ClientExistsException extends RuntimeException{
    public ClientExistsException() {
        super("Client with this same pesel exists");
    }
}
