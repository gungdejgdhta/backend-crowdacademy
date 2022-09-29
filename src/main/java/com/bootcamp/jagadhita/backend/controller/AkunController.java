package com.bootcamp.jagadhita.backend.controller;


import com.bootcamp.jagadhita.backend.dto.AkunDto;
import com.bootcamp.jagadhita.backend.entity.Akun;
import com.bootcamp.jagadhita.backend.service.AkunService;
import com.bootcamp.jagadhita.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/akun")
@Slf4j
public class AkunController {

    @Autowired
    AkunService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try {
            Akun akun = service.findId(id);
            return ResponseEntity.ok(akun);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Data Tidak Ditemukan");
        }
    }

    @GetMapping("")
    public List<Akun> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create
            (@RequestBody @Valid AkunDto.Create akun,
             BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("id", null);
            output.put("status", "Create Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            output.put("id", service.create(akun));
            output.put("status", "Create Data Berhasil");
            return ResponseEntity.ok(output);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<Map<String, Object>> update
            (@RequestBody @Valid AkunDto.Update akun, BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", "Update Data Gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            try {
                service.findId(akun.getId());
                service.update(akun);
                output.put("status", "Update Data Berhasil");
                return ResponseEntity.ok().body(output);
            } catch (EmptyResultDataAccessException e) {
                output.put("status", "Id Tidak Ditemukan");
                return ResponseEntity.badRequest().body(output);
            }
        }
    }
}
