package pl.mk.store.importentMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mk.store.dto.CarDto;
import pl.mk.store.mapper.CarMapper;
import pl.mk.store.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {



    public static List<Car> getListCar() {
        Car car = new Car();
        car.setId(1);
        car.setPrice(2500);
        car.setDescription("TEST DESCRIPTION");
        car.setModel("i118d");
        car.setNrCertificateReg("SK2424");
        car.setBrand("BMW");
        car.setNrVin("12312321D");

        Car car1 = new Car();
        car1.setPrice(2500);
        car1.setDescription("TEST DESCRIPTION");
        car1.setModel("i118d");
        car1.setNrCertificateReg("SK2424");
        car1.setBrand("BMW");

        Car car2 = new Car();
        car2.setId(2);
        car2.setPrice(2500);
        car2.setDescription("TEST DESCRIPTION");
        car2.setModel("i118d");
        car2.setNrCertificateReg("SK2424");
        car2.setBrand("BMW");
        car2.setNrVin("12312321D");

        return Arrays.asList(car, car1, car2);

    }

    public static List<CarDto> getListCarDto() {
        return getListCar()
                .stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
