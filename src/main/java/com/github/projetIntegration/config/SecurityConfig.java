package com.github.projetIntegration.config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final UserAuthentificationEntryPoint userAuthentificationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login").hasRole("ADMIN")
                        .requestMatchers("/register").hasRole("USER")
                        .anyRequest().authenticated()
                );
        return http.build();
    }

}
