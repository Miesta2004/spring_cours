package com.example.spring.web.controllers;

import com.example.spring.data.entities.Categorie;
import com.example.spring.data.entities.Client;
import com.example.spring.web.dto.request.ClientAndCommandesCreateRequest;
import com.example.spring.web.dto.response.CategorieAllResponse;
import com.example.spring.web.dto.response.ClientSimpleResponse;
import com.example.spring.web.dto.response.ClientWithCommandesResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/client")
public interface ClientController extends IController<ClientSimpleResponse> {
    @GetMapping("/one/{id}")
    ResponseEntity<ClientSimpleResponse> getClient(@PathVariable() Long id);
    @GetMapping("")
    ResponseEntity<Map<String,Object>> getClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
    @PostMapping("/create")
    ResponseEntity<ClientSimpleResponse> createClient(Client data);
    @PostMapping("/create/commandes")
    ResponseEntity<ClientAndCommandesCreateRequest> createClientAndCommandes(Client data);
    @PutMapping("/update/{id}")
    ResponseEntity<ClientSimpleResponse> updateClient(@PathVariable() Long id, Client data);
}
