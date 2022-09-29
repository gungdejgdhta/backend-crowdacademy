package com.bootcamp.jagadhita.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Akun {

    Integer id;
    String username;
    String nama_lengkap;
    String alamat;
    Integer umur;
    String universitas;
    User user_id;
}
