package com.example.spring.web.controllers;

import com.example.spring.data.entities.Article;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/article")
// ceci est une URI associée à la requete GET, POST, PUT, DELETE. Ici,
// il s'agit de la requete GET pour la liste des articles.
// Spring Boot va automatiquement mapper cette URI sur la méthode getAllObjects()
// dans la classe implémentant l'interface ArticleController.java.
public interface ArticleController extends IController<Article> {
}
