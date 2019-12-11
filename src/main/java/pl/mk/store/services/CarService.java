package pl.mk.store.services;

import pl.mk.store.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getCarList();
    CarDto saveCar(CarDto carDto);
    CarDto updateCar(CarDto carDto);
    CarDto deleteCar(Integer carId);
}
