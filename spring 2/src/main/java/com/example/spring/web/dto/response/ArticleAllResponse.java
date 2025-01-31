package com.example.spring.web.dto.response;

import com.example.spring.data.entities.Article;
import com.example.spring.data.entities.Categorie;

public class ArticleAllResponse {
    private Long id;
    private String code;
    private String name;
    private Double prix;
    private Integer qteStock;
    private String category;

    public ArticleAllResponse(Article article) {
        this.id = article.getId();
        this.code = article.getCode();
        this.name = article.getName();
        this.prix = article.getPrix();
        this.qteStock = article.getQteStock();
        this.category = article.getCategory().getName();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
