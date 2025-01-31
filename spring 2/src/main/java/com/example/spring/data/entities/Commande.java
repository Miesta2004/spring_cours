package com.example.spring.data.entities;

import com.example.spring.data.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int montantTotal;
    private String dateCommande;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(optional = false)
    private Client client;
    @OneToMany(mappedBy = "commande")
    private List<Detail> details;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
