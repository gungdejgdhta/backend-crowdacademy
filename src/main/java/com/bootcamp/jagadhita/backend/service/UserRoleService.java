package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.UserDao;
import com.bootcamp.jagadhita.backend.dao.UserRoleDao;
import com.bootcamp.jagadhita.backend.entity.User;
import com.bootcamp.jagadhita.backend.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleDao dao;

    public List<UserRole> findAll() {
        return dao.findAll();
    }
}
