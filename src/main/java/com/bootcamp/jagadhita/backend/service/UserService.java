package com.bootcamp.jagadhita.backend.service;


import com.bootcamp.jagadhita.backend.dao.UserDao;
import com.bootcamp.jagadhita.backend.dto.UserDto;
import com.bootcamp.jagadhita.backend.entity.Produk;
import com.bootcamp.jagadhita.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    public List<User> findAll() {
        return dao.findAll();
    }

    @Transactional
    public Integer create(UserDto.Create user) {
        return dao.create(user);
    }
}
