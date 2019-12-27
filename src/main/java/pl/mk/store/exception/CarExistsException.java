package pl.mk.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Car with this vin number exists")
public class CarExistsException extends RuntimeException {
    public CarExistsException() {
        super("Car with this vin number exists");
    }
}
