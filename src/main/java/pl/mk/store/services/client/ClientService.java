package pl.mk.store.services.client;

import pl.mk.store.dto.CarDto;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.model.Client;

import java.util.List;

public interface ClientService {
    List<ClientDto> getClientLists();
    ClientDto saveClient(ClientDto clientDto);
    ClientDto updateClient(ClientDto clientDto);
    ClientDto deleteClient(Integer clientId);
}
