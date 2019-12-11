package pl.mk.store.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import pl.mk.store.dto.CarDto;
import pl.mk.store.model.Car;

public class CarMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static CarDto toDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        return carDto;
    }

    public static Car toEntity(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        return car;
    }

}
