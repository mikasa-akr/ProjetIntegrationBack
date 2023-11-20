package com.github.projetIntegration.services;

import java.util.List;
import java.util.Optional;

import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClient {
    @Autowired
    private UserRepository UtilisateurRepository ;
    public List<Utilisateur> getAllClients(){
        return UtilisateurRepository.findByRole("client");
    }
    public Optional<Utilisateur >getClientbyid(int Id){
        return UtilisateurRepository.findByIdAndRole(Id, "client");
    }
    public Utilisateur valideclient (long Id) {
        Optional<Utilisateur>OptionalUtilisateur=UtilisateurRepository.findById((long)Id);
        if(OptionalUtilisateur.isPresent()) {
            Utilisateur client=OptionalUtilisateur.get();

            return UtilisateurRepository.save(client);
        }
        else {

            throw new RuntimeException("Client not found with id: " + Id);
        }
    }
    public void delete(int id) {
        UtilisateurRepository.deleteById((long)id);
    }
}
