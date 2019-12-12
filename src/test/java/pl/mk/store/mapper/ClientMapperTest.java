package pl.mk.store.mapper;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.importentMethod.ClientFactory;
import pl.mk.store.model.Client;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ClientMapperTest {

    private Client client;
    private ClientDto clientDto;

    @Before
    public void setUp() {
        client = ClientFactory.getListClients().get(0);
        clientDto = ClientFactory.getListClientDto().get(0);

    }



    @Test
    public void shouldReturnMapClientOnClientDto() {
        //given
        //when
        ClientDto clientDto = ClientMapper.toDto(client);
        //then
        assertThat(clientDto, notNullValue());
        assertThat(clientDto.getId(), is(1));
        assertThat(clientDto.getFirstName(), equalTo("Marcin"));

    }

    @Test
    public void shouldMapClientDtoOnClient() {
        //given
        //when
        Client entity = ClientMapper.toEntity(clientDto);
        //
        assertThat(entity, notNullValue());
        assertThat(entity.getId(), is(1));
        assertThat(entity.getFirstName(), equalTo("Marcin"));
    }

}