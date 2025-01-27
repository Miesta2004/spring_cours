package com.example.spring.services;

import com.example.spring.data.entities.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie create(Categorie category);
    Categorie update(Long id,Categorie category);
    boolean delete(Long id);
    Categorie getById(Long id);
    List<Categorie> getAll();

}
