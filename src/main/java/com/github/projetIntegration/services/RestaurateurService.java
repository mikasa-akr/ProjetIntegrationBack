package com.github.projetIntegration.services;

import java.util.List;
import java.util.Optional;

import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestaurateurService {
    @Autowired
    private UserRepository restaurateurRepository;

    public RestaurateurService(UserRepository restaurateurRepository) {
        super();
        this.restaurateurRepository = restaurateurRepository;
    }

    public List<Utilisateur> getAllRestaurateurs() {
        return restaurateurRepository.findByRole("restaurateur");
    }

    public Optional<Utilisateur> getRestaurateurById(int id) {
        return restaurateurRepository.findByIdAndRole(id, "restaurateur");
    }

    public Utilisateur validateRestaurateur(int id) {
        Optional<Utilisateur> optionalRestaurateur = restaurateurRepository.findById((long) id);
        if(optionalRestaurateur.isPresent()) {
            Utilisateur restaurateur=optionalRestaurateur.get();

            return restaurateurRepository.save(restaurateur);
        } else {
            throw new RuntimeException("Restaurateur not found with id: " + id);
        }
    }

    public void deleteRestaurateur(long  restaurateurId) {
        restaurateurRepository.deleteById((long) restaurateurId);
    }

    public void validateOrDeleteRestaurateurByRestaurant(long restaurateurId, long restaurantId, boolean validate) {

        if (validate) {
            validateRestaurateur((int)restaurateurId);
        } else {
            deleteRestaurateur(restaurateurId);
        }
    }
}
