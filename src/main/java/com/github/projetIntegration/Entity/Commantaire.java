package com.github.projetIntegration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "commantaire")
public class Commantaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable =false)
    private String text;
    @Column(nullable =false)
    private Date datePublication;
    @ManyToOne
    private Utilisateur auteur;
}
