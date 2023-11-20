package com.github.projetIntegration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    @NotEmpty
    private String restaurant;

    @NotEmpty
    private Date date;

    @NotEmpty
    private int nb_personne;

}
