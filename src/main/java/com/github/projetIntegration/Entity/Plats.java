package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@Entity
@Table(name = "plats")
public class Plats {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(nullable =false)
        private String nom;
        private float prix;
        //menus
    @ManyToOne
    private Menu menu;
    //offreSpecial
    @OneToMany(mappedBy = "plat")
    private Set<OffreSpecial> offreSpecials;

}
