package com.bootcamp.jagadhita.backend.dto;


import com.bootcamp.jagadhita.backend.entity.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

    @Data
    @NoArgsConstructor
    public static class Create {

        String firstName;

        String username;

        String lastName;

        @NotNull
        @NotEmpty
        String email;

        @NotNull
        @NotEmpty
        String password;

        @NotNull
        Integer role_id;
    }


}
