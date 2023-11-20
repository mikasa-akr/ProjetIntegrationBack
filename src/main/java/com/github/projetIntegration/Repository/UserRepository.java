package com.github.projetIntegration.Repository;
import com.github.projetIntegration.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    List<Utilisateur> findByRole(String role);

    Optional<Utilisateur> findByIdAndRole(int Id, String role);
}
