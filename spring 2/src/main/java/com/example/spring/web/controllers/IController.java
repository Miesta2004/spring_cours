package com.example.spring.web.controllers;

import com.example.spring.web.dto.response.ArticleAllResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/api/v1")
public interface IController<T> {
    // CRUD operations
    @GetMapping("/list")
    //c est une requete GET et on met uri assoccie
    ResponseEntity<List<T>> getAllObjects();
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteObject(@PathVariable() Long id);
}
