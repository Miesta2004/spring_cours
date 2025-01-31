    package com.example.spring.data.repository;

    import com.example.spring.data.entities.Client;
    import com.example.spring.data.entities.Commande;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface CommandeRepository extends JpaRepository<Commande,Long> {
        Page<Commande> findAll(Pageable pageable);
        List<Commande> getCommandeByClient(Client client);
    }
