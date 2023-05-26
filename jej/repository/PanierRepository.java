package com.jeanneeetjean.jej.repository;

import com.jeanneeetjean.jej.model.Colis;
import com.jeanneeetjean.jej.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PanierRepository extends JpaRepository<Panier, Integer> {
    Optional<Panier> findByNom(String nom);
    Optional<Panier> findByMail(String Mail);
}
