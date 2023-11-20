package com.github.projetIntegration.services;

import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.Repository.UserRepository;
import com.github.projetIntegration.dto.UtlisateurDto;
import com.github.projetIntegration.exception.AppException;
import com.github.projetIntegration.mappes.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    public UtlisateurDto findByLogin(String login) {
        Utilisateur user = userRepository.findByEmail(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUtilisateurDto(user);
    }

    public UtlisateurDto login(UtlisateurDto credentialsDto) {
        Utilisateur user = userRepository.findByEmail(credentialsDto.getEmail())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUtilisateurDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UtlisateurDto register(UtlisateurDto userDto) {
        Optional<Utilisateur> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        Utilisateur user = userMapper.signUpToUtilisateur(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        Utilisateur savedUser = userRepository.save(user);

        return userMapper.toUtilisateurDto(savedUser);
    }

}
