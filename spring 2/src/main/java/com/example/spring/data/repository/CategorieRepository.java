package com.example.spring.data.repository;

import com.example.spring.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository <Categorie, Long> {
}
