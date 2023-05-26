package com.jeanneeetjean.jej.repository;

import com.jeanneeetjean.jej.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColisRepository extends JpaRepository<Colis, Integer>{

    Optional<Colis> findByNom(String nom);
    Optional<Colis> findByMail(String Mail);
}
