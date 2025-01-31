package com.example.spring.web.dto.response;

import com.example.spring.data.entities.Article;
import com.example.spring.data.entities.Categorie;
import jakarta.persistence.OneToMany;

import java.util.List;

public class CategorieAllResponse {
    private Long id;
    private String code;
    private String name;

    public CategorieAllResponse(Categorie categorie) {
        this.id = categorie.getId();
        this.code = categorie.getCode();
        this.name = categorie.getName();
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
}
