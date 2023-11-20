package com.github.projetIntegration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    @NotEmpty
    private String nom;
    @NotEmpty
    private String pays;
    @NotEmpty
    private String ville;
    @NotEmpty
    private String photo;
}
