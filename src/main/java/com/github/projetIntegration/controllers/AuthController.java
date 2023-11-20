package com.github.projetIntegration.controllers;

import com.github.projetIntegration.config.UserAuthenticationProvider;
import com.github.projetIntegration.dto.UtlisateurDto;
import com.github.projetIntegration.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UtlisateurDto> login(@RequestBody @Valid UtlisateurDto utilisateurDto) {
        UtlisateurDto userDto = userService.login(utilisateurDto);
        userDto.setEmail(userAuthenticationProvider.createToken(userDto.getEmail()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UtlisateurDto> register(@RequestBody @Valid UtlisateurDto user) {
        UtlisateurDto createdUser = userService.register(user);
        createdUser.setEmail(userAuthenticationProvider.createToken(user.getEmail()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
}

