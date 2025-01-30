package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Article;
import com.example.spring.services.IService;
import com.example.spring.web.controllers.ArticleController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ArticleControllerImpl implements ArticleController {
    private final IService<Article> articleService;

    public ArticleControllerImpl(IService<Article> articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<List<Article>> getAllObjects() {
        var articles = articleService.getAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Article> getOneObject(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Article> createObject(Article data) {
        return null;
    }

    @Override
    public ResponseEntity<Article> updateObject(Long id, Article data) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteObject(Long id) {
        return null;
    }
}
