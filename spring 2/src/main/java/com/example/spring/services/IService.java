package com.example.spring.services;

import java.util.List;

public interface IService<T> {
    T create(T objet);
    T update(Long id,T objet);
    boolean delete(Long id);
    T getById(Long id);
    List<T> getAll();
}
