package com.github.projetIntegration.controllers;

import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.exception.AppException;
import com.github.projetIntegration.services.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ServiceClient serviceutilisateur ;

    @GetMapping
    public List<Utilisateur> getAllClient(int Id){
        return serviceutilisateur.getAllClients();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getClientById(@PathVariable(value = "id") int Id) {
        Utilisateur client = serviceutilisateur.getClientbyid(Id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(client);
    }

    @PutMapping("/validate/{id}")
    public ResponseEntity<Utilisateur> validateClient(@PathVariable(value = "id") int id) {
        Utilisateur validatedClient = serviceutilisateur.valideclient((long)id);
        return ResponseEntity.ok(validatedClient);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id) {
        serviceutilisateur.delete(id);
        return ResponseEntity.ok("Client with id " + id + " deleted successfully.");
    }
}

