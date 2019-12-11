package pl.mk.store.restController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import pl.mk.store.dto.CarDto;
import pl.mk.store.importentMethod.CarFactory;
import pl.mk.store.model.Car;
import pl.mk.store.services.CarService;

import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarRestController.class)
public class CarRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    private String api = "/api/car";

    private CarDto carDtoWithId;
    private CarDto carDtoWithOutId;


    @Before
    public void setUp() {
        carDtoWithId = CarFactory.getListCarDto().get(0);
        carDtoWithOutId = CarFactory.getListCarDto().get(1);
    }


    @Test
    public void shouldReturnCars() throws Exception {
        //given
        given(carService.getCarList()).willReturn(CarFactory.getListCarDto());
        //when
        //then
        mockMvc.perform(get(api))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    public void shouldThrowExceptionIfCarToSaveHaveSetId() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(post(api)
                .contentType(MediaType.APPLICATION_JSON)
                .content(CarFactory.asJsonString(carDtoWithId)))
                    .andExpect(status().isBadRequest());
    }


    @Test
    public void shouldMapAndSaveCar() throws Exception {
        //given
        given(carService.saveCar(carDtoWithOutId)).willReturn(carDtoWithId);
        //when
        //then
        mockMvc.perform(post(api)
                .contentType(MediaType.APPLICATION_JSON)
                .content(CarFactory.asJsonString(carDtoWithOutId)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)));

    }

    @Test
    public void shouldThrowExceptionIfIdInPathIsDifferentThenIdCar() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(put(api + "/{id}", 2)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(CarFactory.asJsonString(carDtoWithId)))
                        .andExpect(status().isConflict());
    }

    @Test
    public void shouldMapAndUpdatedCar() throws Exception{
        //given
        given(carService.updateCar(carDtoWithId)).willReturn(carDtoWithId);
        //when
        //then
        mockMvc.perform(put(api + "/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(CarFactory.asJsonString(carDtoWithId)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void shouldThrowExceptionWhenIdInPathCarToDeleteIsNull() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(delete(api + "/{id}", nullValue()))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void shouldDeleteAndReturnDeletedCar() throws Exception {
        //given
        given(carService.deleteCar(1)).willReturn(carDtoWithId);
        //when
        //then
        mockMvc.perform(delete(api + "/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }










}