package pl.mk.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Car with this id no exists")
public class CarNoExistsException extends RuntimeException{
    public CarNoExistsException() {
        super("Car with this id no exists");
    }
}
