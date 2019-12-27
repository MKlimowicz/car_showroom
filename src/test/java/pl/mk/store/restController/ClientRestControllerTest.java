package pl.mk.store.restController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.importentMethod.CarFactory;
import pl.mk.store.importentMethod.ClientFactory;
import pl.mk.store.services.client.ClientService;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientRestController.class)
public class ClientRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    private String api = "/api/client";

    private ClientDto clientDtoWithId;
    private ClientDto clientDtoWithOutId;

    @Before
    public void setUp() throws Exception {
        clientDtoWithId = ClientFactory.getListClientDto().get(0);
        clientDtoWithOutId = ClientFactory.getListClientDto().get(1);
    }

    // method getListClients()

    @Test
    public void shouldReturnListClients() throws Exception {
        //given
        given(clientService.getClientLists()).willReturn(ClientFactory.getListClientDto());
        //when
        //then
        mockMvc.perform(get(api))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    // method addClient()

    @Test
    public void shouldThrowExceptionWhenIdClientIsSet() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(post(api)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ClientFactory.asJsonString(clientDtoWithId)))
                        .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnSavedClient() throws Exception{
        //given
        given(clientService.saveClient(clientDtoWithOutId)).willReturn(clientDtoWithId);
        //when
        //then
        mockMvc.perform(post(api)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ClientFactory.asJsonString(clientDtoWithOutId)))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.id", is(1)))
                        .andExpect(jsonPath("$.firstName", equalTo("Marcin")));

    }

    // method deleteClient()

    @Test
    public void shouldThrowExceptionIfIdBookToDeleteIsNull() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(delete(api + "/{id}", nullValue()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBookWhichHeJustDeleted() throws Exception {
        //given
        given(clientService.deleteClient(1)).willReturn(clientDtoWithId);
        //when
        //then
        mockMvc.perform(delete(api +"/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", equalTo("Marcin")));
    }



    // method updateClient()

    @Test
    public void shouldThrowExceptionIfIdWithPathIsDifferentThenIdWithClientDto() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(put(api + "/{id}", 2)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ClientFactory.asJsonString(clientDtoWithId)))
                        .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnUpdatedClient() throws Exception {
        //given
        given(clientService.updateClient(clientDtoWithId)).willReturn(clientDtoWithId);
        //when
        //then
        mockMvc.perform(put(api + "/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ClientFactory.asJsonString(clientDtoWithId)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.firstName", equalTo("Marcin")));
    }

}