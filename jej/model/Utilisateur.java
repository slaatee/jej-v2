package com.jeanneeetjean.jej.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="utilisateur")
public class Utilisateur extends AbstractEntity {


    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name = "datedenaissance")
    private Instant dateDeNaissance;

    @Column(name = "mail")
    private String mail;

    @Column(name = "motdepasse")
    private String motDePasse;

    @Column(name = "photo")
    private String photo;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
    @JsonIgnore
    private List<Roles> roles;


}
