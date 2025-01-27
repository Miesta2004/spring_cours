package com.example.spring.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int montantTotal;
    private String dateCommande;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "commande")
    private List<Detail> details;
}
