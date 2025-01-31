package com.example.spring.web.controllers;

import com.example.spring.data.entities.Article;
import com.example.spring.web.dto.request.ArticleCreateRequest;
import com.example.spring.web.dto.response.ArticleAllResponse;
import com.example.spring.web.dto.response.ArticleOneResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/article")
// ceci est une URI associée à la requete GET, POST, PUT, DELETE. Ici,
// il s'agit de la requete GET pour la liste des articles.
// Spring Boot va automatiquement mapper cette URI sur la méthode getAllObjects()
// dans la classe implémentant l'interface ArticleController.java.
public interface ArticleController extends IController<ArticleAllResponse> {
    @GetMapping("/one/{id}")
    ResponseEntity<ArticleOneResponse> getArticle(@PathVariable() Long id);
    @PostMapping("/create")
    ResponseEntity<ArticleOneResponse> createArticle(ArticleCreateRequest data);
    @PutMapping("/update/{id}")
    ResponseEntity<ArticleOneResponse> updateArticle(@PathVariable() Long id, Article data);
    @GetMapping("{id}/articlesByCategorie")
    ResponseEntity<List<ArticleAllResponse>> getArtByCat(Long categoryId);
}
