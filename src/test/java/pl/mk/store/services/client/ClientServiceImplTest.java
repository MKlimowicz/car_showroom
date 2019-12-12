package pl.mk.store.services.client;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.exception.ClientExistsException;
import pl.mk.store.exception.ClientNoExistsException;
import pl.mk.store.importentMethod.ClientFactory;
import pl.mk.store.mapper.ClientMapper;
import pl.mk.store.model.Client;
import pl.mk.store.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


public class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    private String pesel;
    private Client clientWithId;
    private Client clientWithIdTwo;
    private Client clientWithOutId;
    private ClientDto clientDto;
    private ClientDto clientDtoTwo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clientWithId = ClientFactory.getListClients().get(0);
        clientWithIdTwo = ClientFactory.getListClients().get(2);
        clientWithOutId = ClientFactory.getListClients().get(1);
        clientDto = ClientMapper.toDto(clientWithId);
        clientDtoTwo = ClientMapper.toDto(clientWithIdTwo);
        pesel = clientWithId.getPesel();
    }


    @Test
    public void shouldReturnListWithClients() {
        //given
        given(clientRepository.findAll()).willReturn(ClientFactory.getListClients());
        //when
        List<ClientDto> clientLists = clientService.getClientLists();
        //then
        assertThat(clientLists, hasSize(3));

    }

    @Test
    public void shouldThrowExceptionIfExistsClientWithThisSamePeselWhenTrySaveNewClient() {
        //given
        given(clientRepository.findByPesel(pesel)).willReturn(Optional.ofNullable(clientWithId));
        //when
        //then
        assertThrows(ClientExistsException.class, () -> {
                clientService.saveClient(clientDto);
        });

    }

    @Test
    public void shouldMapAndSaveNewClient() {
        //given
        given(clientRepository.findByPesel(pesel)).willReturn(Optional.empty());
        given(clientRepository.save(clientWithId)).willReturn(clientWithId);
        //when
        ClientDto clientDto = clientService.saveClient(this.clientDto);
        //then
        assertThat(clientDto, notNullValue());
        assertThat(clientDto.getPesel(), equalTo(pesel));

        then(clientRepository).should().findByPesel(pesel);
        then(clientRepository).should().save(clientWithId);
    }


    @Test
    public void shouldThrowExceptionWhenWhileUpdateFindClientWithThisSamePeselButDifferentId() {
        //given
        given(clientRepository.findByPesel(pesel)).willReturn(Optional.ofNullable(clientWithId));
        //when
        //then
        assertThrows(ClientExistsException.class, () -> {
            clientService.saveClient(clientDtoTwo);
        });


    }

    @Test
    public void shouldUpdatedAndReturnUpdatedClient() {
        //given
        given(clientRepository.findByPesel(pesel)).willReturn(Optional.ofNullable(clientWithId));
        given(clientRepository.save(clientWithId)).willReturn(clientWithId);
        //when
        ClientDto clientDto1 = clientService.updateClient(clientDto);
        //then
        assertThat(clientDto1, notNullValue());
        assertThat(clientDto1.getPesel(), equalTo(pesel));

        then(clientRepository).should().findByPesel(pesel);
        then(clientRepository).should().save(clientWithId);
    }

    @Test
    public void shouldThrowExceptionIfNoExistsClientWithIdFromClientToDelete() {
        //given
        given(clientRepository.findById(1)).willReturn(Optional.empty());
        //when
        //then
        assertThrows(ClientNoExistsException.class, () -> {
            clientService.deleteClient(1);
        });

    }





    @Test
    public void shouldDeleteClientAndReturnDeletedClient() {
        //given
        given(clientRepository.findById(1)).willReturn(Optional.of(clientWithId));
        //when
        ClientDto clientDto = clientService.deleteClient(1);
        //then
        assertThat(clientDto, notNullValue());
        assertThat(clientDto.getId(), is(1));
    }














}