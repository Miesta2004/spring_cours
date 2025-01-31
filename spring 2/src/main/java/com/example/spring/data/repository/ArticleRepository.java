package com.example.spring.data.repository;

import com.example.spring.data.entities.Article;
import com.example.spring.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> findArticlesByCategory(Categorie category);
}
