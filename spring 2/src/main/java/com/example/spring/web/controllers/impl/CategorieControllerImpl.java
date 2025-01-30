package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Categorie;
import com.example.spring.services.IService;
import com.example.spring.web.controllers.CategorieController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class CategorieControllerImpl implements CategorieController {

    private final IService<Categorie> categorieService;

    public CategorieControllerImpl(IService<Categorie> categorieService) {

        this.categorieService = categorieService;
    }

    @Override
    public ResponseEntity<List<Categorie>> getAllObjects() {
        var categories=categorieService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Categorie> getOneObject(Long id) {
        var cat = categorieService.getById(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Categorie> createObject(@RequestBody() Categorie categorie) {
        var createdCat = categorieService.create(categorie);
        return new ResponseEntity<>(createdCat, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Categorie> updateObject(Long id, Categorie categorie) {
        var updatedCat = categorieService.update(id, categorie);
        return new ResponseEntity<>(updatedCat, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Boolean> deleteObject(Long id) {
        boolean isDeleted = categorieService.delete(id);
        return new ResponseEntity<>(isDeleted,HttpStatus.OK);
    }
}
