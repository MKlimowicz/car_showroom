package pl.mk.store.importentMethod;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mk.store.dto.CarDto;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.mapper.CarMapper;
import pl.mk.store.mapper.ClientMapper;
import pl.mk.store.model.Car;
import pl.mk.store.model.Client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClientFactory {


    public static List<Client> getListClients() {
        Client client = new Client();
        client.setId(1);
        client.setPesel("12345");
        client.setFirstName("Marcin");
        client.setLastName("Testowy");
        client.setAdres("Testowa ulica T/T");
        client.setNip("24122144214141");


        Client client1 = new Client();
        client1.setPesel("12345");
        client1.setFirstName("Marcin");
        client1.setLastName("Testowy");
        client1.setAdres("Testowa ulica T/T");
        client1.setNip("24122144214141");


        Client client2 = new Client();
        client2.setId(2);
        client2.setPesel("12345");
        client2.setFirstName("Marcin");
        client2.setLastName("Testowy");
        client2.setAdres("Testowa ulica T/T");
        client2.setNip("24122144214141");


        return Arrays.asList(client, client1, client2);
    
    }

    public static List<ClientDto> getListClientDto() {
        return getListClients()
                .stream()
                .map(ClientMapper::toDto)
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
