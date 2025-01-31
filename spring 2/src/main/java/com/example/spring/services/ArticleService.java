package com.example.spring.services;

import com.example.spring.data.entities.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {
    List<Article> getArticlesByCategorie(Long categorieId);
}
