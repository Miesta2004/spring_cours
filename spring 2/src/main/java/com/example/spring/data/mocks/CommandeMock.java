package com.example.spring.data.mocks;

import com.example.spring.data.entities.Client;
import com.example.spring.data.entities.Commande;
import com.example.spring.data.enums.Status;
import com.example.spring.data.repository.ClientRepository;
import com.example.spring.data.repository.CommandeRepository;
import com.example.spring.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class CommandeMock implements CommandLineRunner {

    private final CommandeRepository commandeRepository;
    private final ClientService clientService;

    public CommandeMock(CommandeRepository commandeRepository, ClientService clientService) {
        this.commandeRepository = commandeRepository;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Commande> commandes = new ArrayList<>();
        List<Client> clients = clientService.getAll();
        for (Client client : clients) {
            for (int j = 1; j < 10; j++) {
                var commande = new Commande();
                commande.setMontantTotal(1000 * j);
                commande.setDateCommande("2025-01-" + j);
                commande.setStatus(j % 2 == 0 ? Status.EN_COURS : Status.FINALISER);
                commande.setClient(client);
            }
        }
        commandeRepository.saveAllAndFlush(commandes);
    }
}
