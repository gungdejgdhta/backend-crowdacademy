package com.bootcamp.jagadhita.backend.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    Integer id;
    String firstName;
    String username;
    String lastName;
    String email;
    String password;
    UserRole role;
}
