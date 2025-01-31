package com.example.spring.web.dto.request;

import com.example.spring.data.entities.Client;


public class ClientCreateRequest {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

    public Client toEntity(){
        var client = new Client();
        client.setId(this.id);
        client.setNom(this.nom);
        client.setPrenom(this.prenom);
        client.setTelephone(this.telephone);
        client.setAdresse(this.adresse);
        return client;
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
