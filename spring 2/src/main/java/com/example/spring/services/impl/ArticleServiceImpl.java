package com.example.spring.services.impl;

import com.example.spring.data.entities.Article;
import com.example.spring.data.repository.ArticleRepository;
import com.example.spring.data.repository.CategorieRepository;
import com.example.spring.services.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }
    @Override
    public Article create(Article objet) {
        var categorie = categorieRepository.findById(objet.getCategory().getId()).orElse(null);
        if (categorie!= null) {
            objet.setCategory(categorie);
            return articleRepository.save(objet);
        }
        return null;
    }

    @Override
    public Article update(Long id, Article objet) {
        var article = articleRepository.findById(id).orElse(null);
        var categorie = categorieRepository.findById(objet.getCategory().getId()).orElse(null);
        if (article != null && categorie != null) {
            article.setCategory(categorie);
            article.setCode(objet.getCode());
            article.setName(objet.getName());
            article.setPrix(objet.getPrix());
            article.setQteStock(objet.getQteStock());
            return articleRepository.save(article);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            var data = article.get();
            articleRepository.delete(data);
            return true;
        }
        return false;
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getArticlesByCategorie(Long categorieId) {
        var categorie = categorieRepository.findById(categorieId).orElse(null);
        if (categorie != null) {
            return articleRepository.findArticlesByCategory(categorie);
        }
        return null;
    }
}
