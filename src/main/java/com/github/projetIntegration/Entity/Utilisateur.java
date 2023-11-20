package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable =false)
    private String nom;
    @Column(nullable =false)
    private String prenom;
    @Column(nullable =false ,unique = true )
    private String email;
    @Column(nullable =false)
    private String password;
    @Column(nullable =false)
    private String role;
    @Column(nullable =false)
    private String telephone;
    //restaurant
    @OneToMany(mappedBy = "utilisateur")
    private Set<Restaurant> restaurants;
    //reservation
    @OneToMany(mappedBy = "restaurateur")
    private Set<Reservation> reservations;
    //reservation
    @OneToMany(mappedBy = "client")
    private Set<Reservation> resarvations;
    //commentaire
    @OneToMany(mappedBy = "auteur")
    private Set<Commantaire> commantaires;
}
