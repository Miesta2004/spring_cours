package com.example.spring.services.impl;


import com.example.spring.data.entities.Commande;
import com.example.spring.data.repository.CommandeRepository;
import com.example.spring.services.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements IService<Commande> {

    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository){
        this.commandeRepository = commandeRepository;
    }
    @Override
    public Commande create(Commande objet) {
        return commandeRepository.save(objet);
    }

    @Override
    public Commande update(Long id, Commande objet) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if(commande!=null){
            commande.setClient(objet.getClient());
            commande.setDateCommande(objet.getDateCommande());
            commande.setMontantTotal(objet.getMontantTotal());
            return commandeRepository.save(commande);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if(commande!=null){
            commandeRepository.delete(commande);
            return true;
        }
        return false;
    }

    @Override
    public Commande getById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }
}
