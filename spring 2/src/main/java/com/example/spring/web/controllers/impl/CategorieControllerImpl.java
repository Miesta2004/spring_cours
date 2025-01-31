package com.example.spring.web.controllers.impl;

import com.example.spring.data.entities.Categorie;
import com.example.spring.services.IService;
import com.example.spring.web.controllers.CategorieController;
import com.example.spring.web.dto.response.CategorieAllResponse;
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
    public ResponseEntity<List<CategorieAllResponse>> getAllObjects() {
        var categories=categorieService.getAll();
        var categoriesResponse = categories.stream().map(entity -> new CategorieAllResponse(entity)).toList();
        return new ResponseEntity<>(categoriesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategorieAllResponse> getCategorie(Long id) {
        var cat = categorieService.getById(id);
        if (cat!= null) {
            return new ResponseEntity<>(new CategorieAllResponse(cat), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CategorieAllResponse> createCategorie(@RequestBody() Categorie categorie) {
        var createdCat = categorieService.create(categorie);
        return new ResponseEntity<>(new CategorieAllResponse(createdCat), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategorieAllResponse> updateCategorie(Long id, Categorie categorie) {
        var updatedCat = categorieService.update(id, categorie);
        if (updatedCat!= null) {
            return new ResponseEntity<>(new CategorieAllResponse(updatedCat), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Boolean> deleteObject(Long id) {
        boolean isDeleted = categorieService.delete(id);
        return new ResponseEntity<>(isDeleted,HttpStatus.OK);
    }
}
