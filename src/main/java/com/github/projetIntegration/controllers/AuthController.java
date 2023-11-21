package com.github.projetIntegration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.Repository.UserRepository;
import com.github.projetIntegration.config.UserAuthenticationProvider;
import com.github.projetIntegration.dto.CreateUserModel;
import com.github.projetIntegration.dto.LoginUserModel;
import com.github.projetIntegration.dto.UtlisateurDto;
import com.github.projetIntegration.exception.AppException;
import com.github.projetIntegration.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


  /*  @PostMapping("/login")
    public ResponseEntity<UtlisateurDto> login(@RequestBody @Valid UtlisateurDto utilisateurDto) {
        UtlisateurDto userDto = userService.login(utilisateurDto);
        userDto.setEmail(userAuthenticationProvider.createToken(userDto.getEmail()));
        return ResponseEntity.ok(userDto);
    }
*/
//    @PostMapping("/register")
//    public ResponseEntity<UtlisateurDto> register(@RequestBody @Valid UtlisateurDto user) {
//        UtlisateurDto createdUser = userService.register(user);
//        createdUser.setEmail(userAuthenticationProvider.createToken(user.getEmail()));
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
//    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, Object>> login(
            @RequestBody LoginUserModel loginUserModel
    ) {
        var userOp = userRepository.findByEmail(loginUserModel.email());
        var user = userOp.orElseThrow(() -> new AppException("Email Not Found", HttpStatus.FORBIDDEN));
        if (!passwordEncoder.matches(loginUserModel.password(), user.getPassword()))
            throw new AppException("Wrong Password", HttpStatus.FORBIDDEN);

        HashMap<String, Object> resHash = new HashMap<>();
        resHash.put("token", userAuthenticationProvider.createToken(loginUserModel.email()));
        return new ResponseEntity<>(resHash, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<HashMap<String, Object>> register(
            @RequestBody CreateUserModel userModel
    ) {
        var dbUser = userRepository.findByEmail(userModel.email());
        if (dbUser.isPresent())
            throw new AppException("User with email " + userModel.email() + " Already Exists", HttpStatus.BAD_REQUEST);
        Utilisateur user = new Utilisateur();
        user.setNom(userModel.nom());
        user.setPassword(passwordEncoder.encode(userModel.password()));
        user.setEmail(userModel.email());
        user.setPrenom(userModel.prenom());
        user.setRole("USER");
        user.setTelephone(userModel.telephone());
        var savedUser = userRepository.save(user);

        var resHash = new HashMap<String, Object>();
        resHash.put("id", savedUser.getId());
        resHash.put("nom", savedUser.getNom());
        resHash.put("prenom", savedUser.getPrenom());
        resHash.put("email", savedUser.getEmail());
        resHash.put("telephone", savedUser.getTelephone());
        return new ResponseEntity<>(resHash, HttpStatus.OK);
    }
}

