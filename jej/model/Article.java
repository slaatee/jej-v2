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
@Table(name = "article")
public class Article extends AbstractEntity  {

    @Column(name = "nom")
    private String nom;
    @Column(name = "titre")
    private String titre;
    @Column(name = "date")
    private String date;
    @Column (name= "text")
    private String text;
    @Column(name= "lien")
    private String lien;
    @Column(name= "photo")
    private String photo;

}
