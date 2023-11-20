package com.github.projetIntegration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommantaireDto {
    @NotEmpty
    private String text;
    @NotEmpty
    private Date datePublication;

}
