package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Client;
import com.example.spring.services.ClientService;
import com.example.spring.web.controllers.ClientController;
import com.example.spring.web.dto.request.ClientAndCommandesCreateRequest;
import com.example.spring.web.dto.response.ClientSimpleResponse;
import com.example.spring.web.dto.response.RestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ClientSimpleResponse> clientsResponse = clientService.getAllClients(pageable)
                .map(ClientSimpleResponse::new);

        Map<String, Object> response = RestResponse.responsePaginate(
                HttpStatus.OK,
                "ClientSimpleResponse",
                clientsResponse.getContent(),  // Liste paginée des clients
                clientsResponse.getNumber(),   // Page actuelle
                clientsResponse.getTotalPages(),
                (int) clientsResponse.getTotalElements(),
                clientsResponse.isFirst(),
                clientsResponse.isLast()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
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
    public ResponseEntity<ClientAndCommandesCreateRequest> createClientAndCommandes(Client data) {
        ClientAndCommandesCreateRequest clientAndCommandes = clientService.createClientAndCommandes(data);
        if (clientAndCommandes!= null) {
            return new ResponseEntity<>(clientAndCommandes, HttpStatus.CREATED);
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
