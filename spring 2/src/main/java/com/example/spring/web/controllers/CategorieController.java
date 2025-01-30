package com.example.spring.web.controllers;

import com.example.spring.data.entities.Categorie;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/categorie")
public interface CategorieController extends IController<Categorie> {
}
