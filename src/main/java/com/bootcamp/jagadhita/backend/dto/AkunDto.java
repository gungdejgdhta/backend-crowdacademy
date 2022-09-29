package com.bootcamp.jagadhita.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AkunDto {

    @Data
    @NoArgsConstructor
    public static class Create {


        @NotEmpty
        @NotNull
        String username;

        @NotEmpty
        @NotNull
        String nama_lengkap;

        @NotEmpty
        @NotNull
        String alamat;

        @NotNull
        Integer umur;

        @NotEmpty
        @NotNull
        String universitas;

        @NotNull
        Integer app_users_id;

    }

    @Data
    @NoArgsConstructor
    public static class Update {

        @NotNull
        Integer id;

        @NotEmpty
        @NotNull
        String username;

        @NotEmpty
        @NotNull
        String nama_lengkap;

        @NotEmpty
        @NotNull
        String alamat;

        @NotNull
        Integer umur;

        @NotEmpty
        @NotNull
        String universitas;

        @NotNull
        Integer app_users_id;

    }
}
