package com.example.spring.web.dto.request;

import com.example.spring.data.entities.Client;
import com.example.spring.data.entities.Commande;
import com.example.spring.data.enums.Status;

public class CommandeCreateRequest {
    private Long id;
    private int montantTotal;
    private String dateCommande;
    private String status;
    private int clientId;
    
    public Object toEntity(Client client) {
        var commande = new Commande();
        commande.setId(this.id);
        commande.setMontantTotal(this.montantTotal);
        commande.setDateCommande(this.dateCommande);
        commande.setStatus(Status.valueOf(this.status));
        commande.setClient(client);
        return commande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(int montantTotal) {
        this.montantTotal = montantTotal;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int client) {
        this.clientId = client;
    }
}
