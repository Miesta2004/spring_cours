package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Article;
import com.example.spring.services.ArticleService;
import com.example.spring.services.IService;
import com.example.spring.web.controllers.ArticleController;
import com.example.spring.web.dto.request.ArticleCreateRequest;
import com.example.spring.web.dto.response.ArticleAllResponse;
import com.example.spring.web.dto.response.ArticleOneResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleControllerImpl implements ArticleController {
    private final ArticleService articleService;

    public ArticleControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getAllObjects() {
        var articles = articleService.getAll();
        var articlesResponse = articles.stream().map(entity -> new ArticleAllResponse(entity)).toList();
        return new ResponseEntity<>(articlesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> getArticle(Long id) {
        var article = articleService.getById(id);
        if (article!= null) {
            return new ResponseEntity<>(new ArticleOneResponse(article), HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<ArticleOneResponse> createArticle(ArticleCreateRequest data) {
        var createdArticle = articleService.create(data.toEntity());
        if (createdArticle!= null) {
            return new ResponseEntity<>(new ArticleOneResponse(createdArticle), HttpStatus.CREATED);
        }
        return null;
    }

    @Override
    public ResponseEntity<ArticleOneResponse> updateArticle(Long id, Article data) {

        var updatedArticle = articleService.update(id, data);
        if (updatedArticle!= null) {
            return new ResponseEntity<>(new ArticleOneResponse(updatedArticle), HttpStatus.OK);
        }
        return null;    }

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getArtByCat(Long categoryId) {
        var articles = articleService.getArticlesByCategorie(categoryId);
        var articlesResponse = articles.stream().map(entity -> new ArticleAllResponse(entity)).toList();
        return new ResponseEntity<>(articlesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteObject(Long id) {
        boolean isDeleted = articleService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        }
        return null;
    }
}
