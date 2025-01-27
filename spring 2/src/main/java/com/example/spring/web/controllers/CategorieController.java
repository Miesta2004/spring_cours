package com.example.spring.web.controllers;

import com.example.spring.data.entities.Categorie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategorieController {
    // CRUD operations
    @GetMapping("/categorie/list")
    //c est une requete GET et on met uri assoccie
    ResponseEntity<List<Categorie>> getAllCategorie();
    @GetMapping("/categorie/one/{id}")
    ResponseEntity<Categorie> getOne(@PathVariable() Long id);
    @PostMapping("/categorie/create")
    ResponseEntity<Categorie> createCategorie(Categorie categorie);
    @PutMapping("/categorie/update/{id}")
    ResponseEntity<Categorie> updateCategorie(@PathVariable() Long id, Categorie categorie);
    @DeleteMapping("/categorie/delete/{id}")
    ResponseEntity<Boolean> deleteCategorie(@PathVariable() Long id);
}
