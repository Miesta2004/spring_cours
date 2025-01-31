package com.example.spring.services.impl;

import com.example.spring.data.entities.Client;
import com.example.spring.data.repository.ClientRepository;
import com.example.spring.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public Client create(Client objet) {
        return clientRepository.save(objet);
    }

    @Transactional
    @Override
    public Client update(Long id, Client objet) {
        Client client = clientRepository.findById(id).orElse(null);
        if(client!=null){
            client.setNom(objet.getNom());
            client.setPrenom(objet.getPrenom());
            client.setTelephone(objet.getTelephone());
            return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if(client!=null){
            clientRepository.delete(client);
            return true;
        }
        return false;
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
