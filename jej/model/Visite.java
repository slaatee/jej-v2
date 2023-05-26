package com.jeanneeetjean.jej.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "visite")
public class Visite extends AbstractEntity {


    @Column(name = "nom")
    private String nom;
    @Column(name = "texte")
    private String texte;
    @Column(name = "mail")
    private String mail;
    @Column(name = "phone")
    private String phone;
    @Column(name = "date")
    private String date;


}