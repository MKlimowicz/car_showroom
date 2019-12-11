package pl.mk.store.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.mk.store.dto.CarDto;
import pl.mk.store.exception.CarExistsException;
import pl.mk.store.services.CarService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarRestController {

    private CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<CarDto> getListCar() {
        return carService.getCarList();
    }

    @PostMapping()
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto) {
        if(carDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car to save, can't have set id");
        CarDto savedCar = carService.saveCar(carDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedCar);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Integer id, @RequestBody CarDto carDto) {
        if(!carDto.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id in path is different then id f");
        }
        CarDto updatedDto = carService.updateCar(carDto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable Integer id){
        if(id == null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id in path Car to delete is null");
        }
        CarDto carDto = carService.deleteCar(id);
        return ResponseEntity.ok(carDto);
    }
}
