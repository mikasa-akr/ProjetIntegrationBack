package com.github.projetIntegration.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class ErrorDto {
    private String message;
}
