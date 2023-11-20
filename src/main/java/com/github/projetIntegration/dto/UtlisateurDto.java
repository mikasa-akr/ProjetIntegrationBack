package com.github.projetIntegration.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtlisateurDto {

    private int id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "role should not be empty")
    private String role;

}
