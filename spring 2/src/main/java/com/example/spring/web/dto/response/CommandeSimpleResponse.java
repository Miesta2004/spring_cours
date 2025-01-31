package com.example.spring.web.dto.response;

import com.example.spring.data.entities.Client;
import com.example.spring.data.entities.Commande;
import com.example.spring.data.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

public class CommandeSimpleResponse {
    private Long id;
    private int montantTotal;
    private String dateCommande;
    private String status;
    private String client;

    public CommandeSimpleResponse(Commande commande) {
        this.id = commande.getId();
        this.montantTotal = commande.getMontantTotal();
        this.dateCommande = commande.getDateCommande();
        this.status = commande.getStatus().toString();
        this.client = commande.getClient().getNom() + " " + commande.getClient().getPrenom();
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
