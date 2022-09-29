package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.AkunDao;
import com.bootcamp.jagadhita.backend.dto.AkunDto;
import com.bootcamp.jagadhita.backend.entity.Akun;
import com.bootcamp.jagadhita.backend.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AkunService {

    @Autowired
    AkunDao dao;

    public Akun findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Akun> findAll() {
        return dao.findAll();
    }

    @Transactional
    public Integer create(AkunDto.Create akun) {
        return dao.create(akun);
    }

    @Transactional
    public void update(AkunDto.Update akun) {
        dao.update(akun);
    }
}
