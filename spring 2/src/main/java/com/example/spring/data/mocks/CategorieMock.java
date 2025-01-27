package com.example.spring.data.mocks;

import com.example.spring.data.entities.Categorie;
import com.example.spring.data.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategorieMock implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Categorie cat = new Categorie();
            cat.setName("Categorie"+i);
            cat.setCode("CAT"+i);
            categories.add(cat);
        }
        categorieRepository.saveAllAndFlush(categories);
    }
}
