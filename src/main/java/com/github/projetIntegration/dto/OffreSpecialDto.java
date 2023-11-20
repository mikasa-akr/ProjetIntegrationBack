package com.github.projetIntegration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OffreSpecialDto {
    @NotEmpty
    private String nom;
    @NotEmpty
    private float reduction;

}
