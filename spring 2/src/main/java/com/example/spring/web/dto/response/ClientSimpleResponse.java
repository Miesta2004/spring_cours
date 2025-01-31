package com.example.spring.web.dto.response;

import com.example.spring.data.entities.Client;
import com.example.spring.data.entities.Commande;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ClientSimpleResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

    public ClientSimpleResponse(Client client) {
        this.id = client.getId();
        this.nom = client.getNom();
        this.prenom = client.getPrenom();
        this.telephone = client.getTelephone();
        this.adresse = client.getAdresse();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
