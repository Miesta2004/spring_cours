package com.example.spring.services.impl;

import com.example.spring.data.entities.Categorie;
import com.example.spring.data.repository.CategorieRepository;
//import lombok.RequiredArgsConstructor;
import com.example.spring.services.IService;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class CategorieServiceImpl implements IService<Categorie> {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository){
        this.categorieRepository = categorieRepository;
    }


    @Override
    public Categorie create(Categorie category) {
        return categorieRepository.save(category);
    }

    @Override
    public Categorie update(Long id, Categorie category) {
        Categorie cat=categorieRepository.findById(id).orElse(null);
        if(cat!=null){
            cat.setName(category.getName());
            cat.setCode(category.getCode());
            return categorieRepository.save(cat);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Categorie cat=categorieRepository.findById(id).orElse(null);
        if(cat!=null){
            categorieRepository.delete(cat);
             return true;
        }
        return false;
    }

    @Override
    public Categorie getById(Long id) {
        return categorieRepository.findById(id).orElse(null);

    }

    @Override
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }
}
