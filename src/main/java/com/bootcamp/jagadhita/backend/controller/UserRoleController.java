package com.bootcamp.jagadhita.backend.controller;


import com.bootcamp.jagadhita.backend.entity.User;
import com.bootcamp.jagadhita.backend.entity.UserRole;
import com.bootcamp.jagadhita.backend.service.UserRoleService;
import com.bootcamp.jagadhita.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@Slf4j

public class UserRoleController {

    @Autowired
    UserRoleService service;

    @GetMapping("")
    public List<UserRole> findAll() {
        return service.findAll();
    }
}
