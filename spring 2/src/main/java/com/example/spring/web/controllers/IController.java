package com.example.spring.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/api/v1")
public interface IController<T> {
    // CRUD operations
    @GetMapping("/list")
    //c est une requete GET et on met uri assoccie
    ResponseEntity<List<T>> getAllObjects();
    @GetMapping("/one/{id}")
    ResponseEntity<T> getOneObject(@PathVariable() Long id);
    @PostMapping("/create")
    ResponseEntity<T> createObject(T data);
    @PutMapping("/update/{id}")
    ResponseEntity<T> updateObject(@PathVariable() Long id, T data);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteObject(@PathVariable() Long id);
}
