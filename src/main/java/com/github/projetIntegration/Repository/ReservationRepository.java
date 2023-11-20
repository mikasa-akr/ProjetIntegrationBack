package com.github.projetIntegration.Repository;

import java.util.List;

import com.github.projetIntegration.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    // Autres méthodes du repository

    // Trouver toutes les réservations en attente de validation
}