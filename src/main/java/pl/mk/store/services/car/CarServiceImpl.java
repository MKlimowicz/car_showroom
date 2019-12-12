package pl.mk.store.services.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mk.store.dto.CarDto;

import pl.mk.store.exception.CarExistsException;
import pl.mk.store.exception.CarNoExistsException;
import pl.mk.store.mapper.CarMapper;
import pl.mk.store.model.Car;
import pl.mk.store.repository.CarRepository;
import pl.mk.store.services.car.CarService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {


    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> getCarList() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto saveCar(CarDto carDto) {
        Optional<Car> byNrVin = carRepository.findByNrVin(carDto.getNrVin());
        byNrVin.ifPresent(a -> {
            throw new CarExistsException();
        });

        return mapAndSave(carDto);
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        Optional<Car> byNrVin = carRepository.findByNrVin(carDto.getNrVin());
        byNrVin.ifPresent(c -> {
            if (!c.getId().equals(carDto.getId())){
                throw new CarExistsException();
            }
        });
        return mapAndSave(carDto);
    }

    @Override
    public CarDto deleteCar(Integer carId) {
        Optional<Car> entityById = carRepository.findById(carId);
        Car entityToDelete = entityById.orElseThrow(CarNoExistsException::new);
        carRepository.delete(entityToDelete);
        return CarMapper.toDto(entityToDelete);

    }

    private CarDto mapAndSave(CarDto carDto) {
        Car entity = CarMapper.toEntity(carDto);
        Car savedCar = carRepository.save(entity);
        return CarMapper.toDto(savedCar);
    }
}
