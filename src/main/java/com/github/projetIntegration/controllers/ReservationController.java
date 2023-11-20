package com.github.projetIntegration.controllers;

import java.util.List;

import com.github.projetIntegration.Entity.Reservation;
import com.github.projetIntegration.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @ResponseBody
    @GetMapping("reservations")
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        System.out.println(reservations);
        return reservations;
    }
}