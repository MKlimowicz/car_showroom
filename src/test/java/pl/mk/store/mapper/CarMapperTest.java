package pl.mk.store.mapper;

import org.junit.Before;
import org.junit.Test;
import pl.mk.store.dto.CarDto;
import pl.mk.store.model.Car;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CarMapperTest {


    private Car car;
    private CarMapper carMapper = new CarMapper();

    @Before
    public void setUp() {
        car =  createCar();
    }


    @Test
    public void shouldMappingEntityToDto() {
        //given
        //when
        CarDto carDto = carMapper.toDto(car);
        //then
        assertThat(carDto, notNullValue());
        assertThat(carDto.getId(), is(1));
        assertThat(carDto.getBrand(), equalTo("BMW"));
        assertThat(carDto.getModel(), equalTo("i118d"));
        assertThat(carDto.getNrCertificateReg(), equalTo("SK2424"));
    }

    @Test
    public void shouldMtoEntity() {
        //given
        CarDto carDto = carMapper.toDto(car);
        //when
        Car car = carMapper.toEntity(carDto);
        //then
        assertThat(car, notNullValue());
        assertThat(car.getId(), is(1));
        assertThat(car.getBrand(), equalTo("BMW"));
        assertThat(car.getModel(), equalTo("i118d"));
        assertThat(car.getNrCertificateReg(), equalTo("SK2424"));

    }



    private Car createCar() {
        Car car = new Car();
        car.setId(1);
        car.setPrice(2500);
        car.setDescription("TEST DESCRIPTION");
        car.setModel("i118d");
        car.setNrCertificateReg("SK2424");
        car.setBrand("BMW");

        return car;
    }
}