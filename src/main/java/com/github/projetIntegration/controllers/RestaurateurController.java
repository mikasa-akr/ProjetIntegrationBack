package com.github.projetIntegration.controllers;

import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.services.RestaurateurService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.projetIntegration.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/restaurateurs")
public class RestaurateurController {

    @Autowired
    private RestaurateurService serviceRestaurateur;


    public RestaurateurController(RestaurateurService serviceRestaurateur) {
        super();
        this.serviceRestaurateur = serviceRestaurateur;
    }

    @GetMapping
    public List<Utilisateur> getAllRestaurateurs() {
        return serviceRestaurateur.getAllRestaurateurs();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getRestaurateurById(@PathVariable(value = "id") int id) {
        Utilisateur restaurateur = serviceRestaurateur.getRestaurateurById(id)
                .orElseThrow(() ->  new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(restaurateur);
    }

    @PutMapping("/validate/{id}")
    public ResponseEntity<Utilisateur> validateRestaurateur(@PathVariable(value = "id") int id) {
        Utilisateur validatedRestaurateur = serviceRestaurateur.validateRestaurateur((int) id);
        return ResponseEntity.ok(validatedRestaurateur);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestaurateur(@PathVariable(value = "id") int id) {
        serviceRestaurateur.deleteRestaurateur(id);
        return ResponseEntity.ok("Restaurateur with id " + id + " deleted successfully.");
    }

    @PutMapping("/validateOrDelete/{restaurateurId}/{restaurantId}/{validate}")
    public ResponseEntity<String> validateOrDeleteRestaurateurByRestaurant(
            @PathVariable(value = "restaurateurId") long restaurateurId,
            @PathVariable(value = "restaurantId") long restaurantId,
            @PathVariable(value = "validate") boolean validate) {
        serviceRestaurateur.validateOrDeleteRestaurateurByRestaurant(restaurateurId, restaurantId, validate);
        return ResponseEntity.ok("Operation performed successfully.");
    }
}
