package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "offre_special")
public class OffreSpecial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable =false)
    private String nom;
    private float reduction;
    @ManyToOne
    private Plats plat;
}
