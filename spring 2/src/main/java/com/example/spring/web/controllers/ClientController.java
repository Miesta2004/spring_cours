package com.example.spring.web.controllers;

import com.example.spring.data.entities.Categorie;
import com.example.spring.data.entities.Client;
import com.example.spring.web.dto.response.CategorieAllResponse;
import com.example.spring.web.dto.response.ClientSimpleResponse;
import com.example.spring.web.dto.response.ClientWithCommandesResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/client")
public interface ClientController extends IController<ClientSimpleResponse> {
    @GetMapping("/one/{id}")
    ResponseEntity<ClientSimpleResponse> getClient(@PathVariable() Long id);
    @GetMapping("")
    ResponseEntity<Page<ClientSimpleResponse>> getClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
    @PostMapping("/create")
    ResponseEntity<ClientSimpleResponse> createClient(Client data);
    @PutMapping("/update/{id}")
    ResponseEntity<ClientSimpleResponse> updateClient(@PathVariable() Long id, Client data);
    @GetMapping("/one/{id}/commandes")
    ResponseEntity<ClientWithCommandesResponse> getClientWithCommandes(@PathVariable() Long id);
}
