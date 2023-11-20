package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable =false)
    private String restaurant;
    @Column(nullable =false)
    private Date date;
    @Column(nullable =false)
    private int nb_personne;
    //restaurateur
    @ManyToOne
    private Utilisateur restaurateur;
    //client
    @ManyToOne
    private Utilisateur client;



}
