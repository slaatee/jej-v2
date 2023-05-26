package com.jeanneeetjean.jej.repository;

import com.jeanneeetjean.jej.model.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisiteRepository extends JpaRepository<Visite, Integer>{
    Optional<Visite> findByNom(String nom);
    Optional<Visite> findByMail(String Mail);
}