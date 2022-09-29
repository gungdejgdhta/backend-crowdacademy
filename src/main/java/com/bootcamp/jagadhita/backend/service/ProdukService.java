package com.bootcamp.jagadhita.backend.service;

import com.bootcamp.jagadhita.backend.dao.ProdukDao;
import com.bootcamp.jagadhita.backend.dto.ProdukDto;
import com.bootcamp.jagadhita.backend.dto.ProdusenDto;
import com.bootcamp.jagadhita.backend.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdukService {

    @Autowired
    ProdukDao dao;

    public Produk findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Produk> findAll() {
        return dao.findAll();
    }

    @Transactional
    public Integer create(ProdukDto.Create produk) {
        return dao.create(produk);
    }

    @Transactional
    public void update(ProdukDto.Update produk) {
        dao.update(produk);
    }

    @Transactional
    public void delete(Integer id) {
        dao.delete(id);
    }

}
