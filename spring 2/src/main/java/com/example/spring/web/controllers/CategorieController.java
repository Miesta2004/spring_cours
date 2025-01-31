package com.example.spring.web.controllers;

import com.example.spring.data.entities.Article;
import com.example.spring.data.entities.Categorie;
import com.example.spring.web.dto.response.ArticleAllResponse;
import com.example.spring.web.dto.response.CategorieAllResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/categorie")
public interface CategorieController extends IController<CategorieAllResponse> {
    @GetMapping("/one/{id}")
    ResponseEntity<CategorieAllResponse> getCategorie(@PathVariable() Long id);
    @PostMapping("/create")
    ResponseEntity<CategorieAllResponse> createCategorie(Categorie data);
    @PutMapping("/update/{id}")
    ResponseEntity<CategorieAllResponse> updateCategorie(@PathVariable() Long id, Categorie data);

}
