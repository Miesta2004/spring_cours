package com.example.spring.services.impl;

import com.example.spring.data.entities.Article;
import com.example.spring.data.repository.ArticleRepository;
import com.example.spring.services.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements IService<Article> {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @Override
    public Article create(Article objet) {
        return articleRepository.save(objet);
    }

    @Override
    public Article update(Long id, Article objet) {
        var article = articleRepository.findById(id).orElse(null);
        if (article != null) {
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
}
