package com.github.projetIntegration.dto;

public record CreateUserModel(
        String nom,
        String prenom,
        String telephone,
        String email,
        String password
) {
}
