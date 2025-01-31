package com.example.spring.services;

import com.example.spring.data.entities.Client;
import com.example.spring.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommandeService extends IService<Commande> {
    Page<Commande> getAllCommandes(Pageable pageable);
    List<Commande> getCommandeByClient(Client client);

}
