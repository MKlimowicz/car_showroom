package pl.mk.store.mapper;

import org.modelmapper.ModelMapper;
import pl.mk.store.dto.CarDto;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.model.Car;
import pl.mk.store.model.Client;

public class ClientMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ClientDto toDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    public static Client toEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }
}
