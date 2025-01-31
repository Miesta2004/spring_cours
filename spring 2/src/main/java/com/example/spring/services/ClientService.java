package com.example.spring.services;

import com.example.spring.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClientService extends IService<Client> {
    Page<Client> getAllClients(Pageable pageable);
}
