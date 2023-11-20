package com.github.projetIntegration.mappes;
import com.github.projetIntegration.Entity.Utilisateur;
import com.github.projetIntegration.dto.UtlisateurDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UtlisateurDto toUtilisateurDto(Utilisateur user);

    @Mapping(target = "password", ignore = true)
    Utilisateur signUpToUtilisateur(UtlisateurDto signUpDto);

}