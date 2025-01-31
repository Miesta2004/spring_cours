package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Client;
import com.example.spring.services.ClientService;
import com.example.spring.services.IService;
import com.example.spring.web.controllers.ClientController;
import com.example.spring.web.dto.request.ClientAndCommandesCreateRequest;
import com.example.spring.web.dto.response.ClientSimpleResponse;
import com.example.spring.web.dto.response.ClientWithCommandesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }
    @Override
    public ResponseEntity<ClientSimpleResponse> getClient(Long id) {
        Client client = clientService.getById(id);
        if (client!= null) {
            return new ResponseEntity<>(new ClientSimpleResponse(client), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<ClientSimpleResponse>> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var clients = clientService.getAllClients(pageable);
        Page<ClientSimpleResponse> clientsResponse = clients.map(entity -> new ClientSimpleResponse(entity));
        return new ResponseEntity<>(clientsResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientSimpleResponse> createClient(Client data) {
        Client client = clientService.create(data);
        if (client!= null) {
            return new ResponseEntity<>(new ClientSimpleResponse(client), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ClientSimpleResponse> updateClient(Long id, Client data) {
        Client client = clientService.update(id, data);
        if (client!= null) {
            return new ResponseEntity<>(new ClientSimpleResponse(client), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ClientWithCommandesResponse> getClientWithCommandes(Long clientId) {
        Client client = clientService.getById(clientId);
        if (client!= null) {
            return new ResponseEntity<>(new ClientWithCommandesResponse(client), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);    }

    @Override
    public ResponseEntity<List<ClientSimpleResponse>> getAllObjects() {
        List<Client> clients = clientService.getAll();
        List<ClientSimpleResponse> clientsResponse = clients.stream().map(entity -> new ClientSimpleResponse(entity)).toList();
        return new ResponseEntity<>(clientsResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteObject(Long id) {
        boolean isDeleted = clientService.delete(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
