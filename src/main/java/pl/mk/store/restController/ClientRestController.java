package pl.mk.store.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.mk.store.dto.ClientDto;
import pl.mk.store.services.client.ClientService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping()
    public List<ClientDto> getListClients() {
        return clientService.getClientLists();
    }

    @PostMapping()
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto) {
        if(clientDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client to save can't set id");
        ClientDto savedClient = clientService.saveClient(clientDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClient.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedClient);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        if(!clientDto.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client should have set this same id what is in path");
        }
        ClientDto updateClient = clientService.updateClient(clientDto);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable Integer id) {
        if(id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id must by set when you try delete client");
        }
        ClientDto clientDto = clientService.deleteClient(id);
        return ResponseEntity.ok(clientDto);
    }


}
