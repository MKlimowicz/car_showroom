package pl.mk.store.services.car;


import pl.mk.store.dto.CarDto;
import pl.mk.store.exception.CarExistsException;
import pl.mk.store.exception.CarNoExistsException;
import pl.mk.store.importentMethod.CarFactory;
import pl.mk.store.mapper.CarMapper;
import pl.mk.store.model.Car;
import pl.mk.store.repository.CarRepository;

import java.util.List;
import java.util.Optional;

import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.mk.store.services.car.CarServiceImpl;

public class CarServiceTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    private Car carWithId1;
    private Car getCarWithId2;
    private CarDto carDto;
    private String nrVin;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        carWithId1 = CarFactory.getListCar().get(0);
        getCarWithId2 = CarFactory.getListCar().get(2);
        carDto = CarMapper.toDto(carWithId1);
        nrVin = carWithId1.getNrVin();

    }


    @Test
    public void shouldReturnListWithCarDto() {
        //given
        given(carRepository.findAll()).willReturn(CarFactory.getListCar());
        //when
        List<CarDto> carList = carService.getCarList();
        //then
        assertThat(carList, hasSize(3));
        assertThat(carList.get(0).getId(), is(1));

    }

    @Test
    public void shouldThrowExceptionIfExistsCarWithThisSameNumberVin() {
        //given
        given(carRepository.findByNrVin(nrVin)).willReturn(Optional.of(carWithId1));
        //when
        //then
        assertThrows(CarExistsException.class, () -> {
            carService.saveCar(carDto);
        });

        then(carRepository).should().findByNrVin(nrVin);
    }

    @Test
    public void shouldReturnMapSavedCar() {
        //given
        given(carRepository.findByNrVin(nrVin)).willReturn(Optional.empty());
        given(carRepository.save(carWithId1)).willReturn(carWithId1);
        //when
        CarDto carDto = carService.saveCar(this.carDto);
        //then
        assertThat(carDto, notNullValue());
        then(carRepository).should().findByNrVin(nrVin);
        then(carRepository).should().save(carWithId1);
    }

    @Test
    public void shouldThrowExceptionIfExistsCarWithThisSameNrVinButDifferentIdThenUpdateCar() {
        //given
        given(carRepository.findByNrVin(nrVin)).willReturn(Optional.ofNullable(carWithId1));
        //when
        //then
        assertThrows(CarExistsException.class, () -> {
            carService.updateCar(CarFactory.getListCarDto().get(2));
        });

    }

    @Test
    public void shouldThrowExceptionWhenCarWithIdToDeleteNoExists() {
        //given
        given(carRepository.findById(1)).willReturn(Optional.empty());
        //when
        //then
        assertThrows(CarNoExistsException.class, () -> {
            carService.deleteCar(1);
        });

    }

    @Test
    public void shouldReturnDeletedCar() {
        //given
        given(carRepository.findById(1)).willReturn(Optional.ofNullable(carWithId1));
        //when
        CarDto carDto = carService.deleteCar(1);
        //then
        assertThat(carDto, notNullValue());
    }



}