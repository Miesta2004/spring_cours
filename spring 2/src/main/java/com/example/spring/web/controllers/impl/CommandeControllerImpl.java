package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Commande;
import com.example.spring.services.ClientService;
import com.example.spring.services.CommandeService;
import com.example.spring.web.controllers.CommandeController;
import com.example.spring.web.dto.response.CommandeSimpleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeControllerImpl implements CommandeController {

    private final CommandeService commandeService;
    private final ClientService clientService;

    public CommandeControllerImpl(CommandeService commandeService, ClientService clientService) {
        this.commandeService = commandeService;
        this.clientService = clientService;
    }
    @Override
    public ResponseEntity<CommandeSimpleResponse> getCommande(Long id) {
        Commande commande = commandeService.getById(id);
        if (commande!= null) {
            return new ResponseEntity<>(new CommandeSimpleResponse(commande), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<CommandeSimpleResponse>> getCommandes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> commandes = commandeService.getAllCommandes(pageable);
        Page<CommandeSimpleResponse> commandesResponse = commandes.map(entity -> new CommandeSimpleResponse(entity));
        return new ResponseEntity<>(commandesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeSimpleResponse> createCommande(Commande data) {
        Commande commande = commandeService.create(data);
        if (commande!= null) {
            return new ResponseEntity<>(new CommandeSimpleResponse(commande), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CommandeSimpleResponse> updateCommande(Long id, Commande data) {
        Commande commande = commandeService.update(id, data);
        if (commande!= null) {
            return new ResponseEntity<>(new CommandeSimpleResponse(commande), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CommandeSimpleResponse>> getCommandesByClient(Long id) {
        var client = clientService.getById(id);
        if (client!= null) {
            var commandes = commandeService.getCommandeByClient(client);
            List<CommandeSimpleResponse> commandesResponse = commandes.stream().map(entity -> new CommandeSimpleResponse(entity)).toList();
            return new ResponseEntity<>(commandesResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CommandeSimpleResponse>> getAllObjects() {
        List<Commande> commandes = commandeService.getAll();
        List<CommandeSimpleResponse> commandesResponse = commandes.stream().map(entity -> new CommandeSimpleResponse(entity)).toList();
        return new ResponseEntity<>(commandesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteObject(Long id) {
        boolean isDeleted = commandeService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
