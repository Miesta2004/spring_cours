package com.example.spring.data.mocks;

import com.example.spring.data.entities.Client;
import com.example.spring.data.entities.Commande;
import com.example.spring.data.enums.Status;
import com.example.spring.data.repository.CommandeRepository;
import com.example.spring.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class ClientMock implements CommandLineRunner {
    private final ClientService clientService;

    public ClientMock(ClientService clientService) {
        this.clientService = clientService;
    }

    public void run(String... args) throws Exception {
        for(int i = 1; i < 15; i++){
            var client = new Client();
            client.setNom("Nom"+i);
            client.setPrenom("Prenom"+i);
            client.setTelephone("7710010"+i);
            client.setAdresse("Adresse"+i);
            clientService.create(client);
        }
    }
}
