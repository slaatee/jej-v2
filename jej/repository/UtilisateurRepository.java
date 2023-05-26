package com.jeanneeetjean.jej.repository;

import com.jeanneeetjean.jej.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    @Query(value = "select u from Utilisateur u where u.mail = :mail")
    Optional<Utilisateur> findUtilisateurByEmail(@Param("mail") String mail);
}
