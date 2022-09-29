package com.bootcamp.jagadhita.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRoleDto {

    @Data
    @NoArgsConstructor
    public static class Create {

        @NotNull
        Integer id;

        @NotNull
        @NotEmpty
        String role;
    }
}
