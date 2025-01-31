package com.example.spring.data.mocks;

import com.example.spring.data.entities.Article;
import com.example.spring.data.entities.Categorie;
import com.example.spring.data.repository.ArticleRepository;
import com.example.spring.services.IService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class ArticleMock implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final IService<Categorie> categorieService;

    public ArticleMock(ArticleRepository articleRepository, IService<Categorie> categorieService) {
        this.articleRepository = articleRepository;
        this.categorieService = categorieService;
    }
    @Override
    public void run(String... args) throws Exception {
        List<Article> articles = new ArrayList<>();
        List<Categorie> categories = categorieService.getAll();
        for (Categorie category : categories) {
            for(int i = 1; i < 10; i++){
                Article art = new Article();
                art.setName("Article"+category.getName() + i);
                art.setCode("ART"+ category.getCode() + i);
                art.setPrix(Math.random()*100);
                art.setQteStock((int)(Math.random()*100));
                art.setCategory(category);
                articles.add(art);
            }
        }
        articleRepository.saveAllAndFlush(articles);
    }
}
