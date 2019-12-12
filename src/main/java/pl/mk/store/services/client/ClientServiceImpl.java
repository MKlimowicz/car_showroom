package pl.mk.store.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.exception.ClientExistsException;
import pl.mk.store.exception.ClientNoExistsException;
import pl.mk.store.mapper.ClientMapper;
import pl.mk.store.model.Client;
import pl.mk.store.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> getClientLists() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Optional<Client> entityByPesel = clientRepository.findByPesel(clientDto.getPesel());
        entityByPesel.ifPresent(e -> {
            throw new ClientExistsException();
        });

        return makeAndSave(clientDto);
    }

    private ClientDto makeAndSave(ClientDto clientDto) {
        Client entity = ClientMapper.toEntity(clientDto);
        Client savedEntity = clientRepository.save(entity);
        return ClientMapper.toDto(savedEntity);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Optional<Client> entityByPesel = clientRepository.findByPesel(clientDto.getPesel());
        entityByPesel.ifPresent(entity -> {
            if (!entity.getId().equals(clientDto.getId())) {
                throw new ClientExistsException();
            }
        });

        return makeAndSave(clientDto);

    }

    @Override
    public ClientDto deleteClient(Integer clientId) {
        Optional<Client> entityById = clientRepository.findById(clientId);
        Client entity = entityById.orElseThrow(ClientNoExistsException::new);
        return ClientMapper.toDto(entity);
    }
}
