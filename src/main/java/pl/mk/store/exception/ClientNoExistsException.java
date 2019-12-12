package pl.mk.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Client with this id no exists")
public class ClientNoExistsException extends RuntimeException{
    public ClientNoExistsException() {
        super("Client with this id no exists");
    }
}
