package com.bootcamp.jagadhita.backend.controller;


import com.bootcamp.jagadhita.backend.dto.ProdukDto;
import com.bootcamp.jagadhita.backend.dto.UserDto;
import com.bootcamp.jagadhita.backend.entity.Produk;
import com.bootcamp.jagadhita.backend.entity.User;
import com.bootcamp.jagadhita.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Slf4j

public class UserController {

    @Autowired
    UserService service;

    @GetMapping("")
    public List<User> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create
            (@RequestBody @Valid UserDto.Create user,
             BindingResult result) {
        Map<String, Object> output = new HashMap<>();

        if (result.hasErrors()) {
            output.put("id", null);
            output.put("status", "Create Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            output.put("id", service.create(user));
            output.put("status", "Create Data Berhasil");
            return ResponseEntity.ok(output);
        }
    }
}
