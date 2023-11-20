package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable =false)
    private String nom;
    //plate
    @OneToMany(mappedBy = "menu")
    private Set<Plats> plates;
    //restaurant
    @ManyToOne
    private Restaurant restaurant;



}
