package com.example.spring.web.controllers;

import com.example.spring.data.entities.Commande;
import com.example.spring.web.dto.response.CommandeSimpleResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/commande")
public interface CommandeController extends IController<CommandeSimpleResponse> {
    @GetMapping("/one/{id}")
    ResponseEntity<CommandeSimpleResponse> getCommande(@PathVariable() Long id);
    @GetMapping("")
    ResponseEntity<Page<CommandeSimpleResponse>> getCommandes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
    @PostMapping("/create")
    ResponseEntity<CommandeSimpleResponse> createCommande(Commande data);
    @PutMapping("/update/{id}")
    ResponseEntity<CommandeSimpleResponse> updateCommande(@PathVariable() Long id, Commande data);
    @GetMapping("/all/{id}")
    ResponseEntity<List<CommandeSimpleResponse>> getCommandesByClient(@PathVariable() Long id);
}
