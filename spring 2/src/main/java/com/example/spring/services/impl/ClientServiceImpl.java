package com.example.spring.services.impl;

import com.example.spring.data.entities.Client;
import com.example.spring.data.repository.ClientRepository;
import com.example.spring.services.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IService<Client> {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client objet) {
        return clientRepository.save(objet);
    }

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
}
