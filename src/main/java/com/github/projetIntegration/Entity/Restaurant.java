package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable =false)
    private String nom;
    @Column(nullable =false)
    private String pays;
    @Column(nullable =false)
    private String ville;
    @Column(nullable =false)
    private String photo;
    //menu
    @OneToMany(mappedBy = "restaurant")
    private Set<Menu> Menus;
    //restaurateur
    @ManyToOne
    private Utilisateur utilisateur;
}
