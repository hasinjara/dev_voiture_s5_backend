package com.demo.voiture.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    String idUser;
    String nom;
    String prenom;
    String mail;
    String role;
}
