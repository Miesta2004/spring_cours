package com.example.spring.web.dto.request;

import com.example.spring.data.entities.Article;
import com.example.spring.data.entities.Categorie;

public class ArticleCreateRequest {
    private Long id;
    private String code;
    private String name;
    private Double prix;
    private Integer qteStock;
    private Long categoryId;

    public Article toEntity(){
        var article = new Article();
        var category = new Categorie();
        category.setId(categoryId);
        article.setId(this.id);
        article.setCode(this.code);
        article.setName(this.name);
        article.setPrix(this.prix);
        article.setQteStock(this.qteStock);
        article.setCategory(category);
        return article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQteStock() {
        return qteStock;
    }

    public void setQteStock(Integer qteStock) {
        this.qteStock = qteStock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
