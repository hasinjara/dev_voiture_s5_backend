package com.demo.voiture.config;

import com.demo.voiture.filters.JwtAuthenticationFilter;
import com.demo.voiture.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                        //-register
                        .requestMatchers(HttpMethod.POST,"/register/signup","/register/signin").permitAll()
                        .requestMatchers(HttpMethod.GET, "/app/test/**").permitAll()
                        //-annonce
                        .requestMatchers(HttpMethod.GET, "/annonce/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/annonce/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/annonce/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/annonce/**").permitAll()
                        //-boite
                        .requestMatchers(HttpMethod.GET, "/boite/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/boite/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/boite/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/boite/**").permitAll()
                        //-categorie
                        .requestMatchers(HttpMethod.GET, "/categorie/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/categorie/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/categorie/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/categorie/**").permitAll()
                        //-energie
                        .requestMatchers(HttpMethod.GET, "/energie/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/energie/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/energie/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/energie/**").permitAll()
                        //-marque
                        .requestMatchers(HttpMethod.GET, "/marque/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/marque/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/marque/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/marque/**").permitAll()
                        //-voiture
                        .requestMatchers(HttpMethod.GET, "/voiture/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/voiture/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/voiture/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/voiture/**").permitAll()
                        //--
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
