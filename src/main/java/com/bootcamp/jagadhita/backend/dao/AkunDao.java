package com.bootcamp.jagadhita.backend.dao;

import com.bootcamp.jagadhita.backend.dto.AkunDto;
import com.bootcamp.jagadhita.backend.entity.Akun;
import com.bootcamp.jagadhita.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AkunDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Akun findId(Integer id) {
        String query = "SELECT akun.id, akun.username, akun.nama_lengkap, akun.alamat, akun.umur, akun.universitas,\n" +
                "app_users.id as app_users_id,\n" +
                "app_users.email as app_users_email,\n" +
                "app_users.password as app_users_pass\n" +
                "FROM public.akun akun\n" +
                "LEFT JOIN app_users app_users on akun.app_users_id = app_users.id\n" +
                "WHERE akun.id = :idAkun";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProduk", id);

        return jdbcTemplate.queryForObject(query, map, new RowMapper<Akun>() {
            @Override
            public Akun mapRow(ResultSet rs, int rowNum) throws SQLException {
                Akun akun = new Akun();
                akun.setId(rs.getInt("id"));
                akun.setUsername(rs.getString("username"));
                akun.setNama_lengkap(rs.getString("nama_lengkap"));
                akun.setAlamat(rs.getString("alamat"));
                akun.setUmur(rs.getInt("umur"));
                akun.setUniversitas(rs.getString("universitas"));

                User user = new User();
                user.setId(rs.getInt("app_users_id"));
                user.setEmail(rs.getString("app_users_email"));
                user.setPassword(rs.getString("app_users_pass"));

                akun.setUser_id(user);
                return akun;
            }
        });
    }

    public List<Akun> findAll() {
        String query = "SELECT akun.id, akun.username, akun.nama_lengkap, akun.alamat, akun.umur, akun.universitas," +
                "app_users.id as app_users_id,\n" +
                "app_users.email as app_users_email,\n" +
                "app_users.password as app_users_pass\n" +
                "FROM public.akun akun\n" +
                "LEFT JOIN app_users app_users on akun.app_users_id = app_users.id";

        return jdbcTemplate.query(query, new RowMapper<Akun>() {
            @Override
            public Akun mapRow(ResultSet rs, int rowNum) throws SQLException {
                Akun akun = new Akun();
                akun.setId(rs.getInt("id"));
                akun.setUsername(rs.getString("username"));
                akun.setNama_lengkap(rs.getString("nama_lengkap"));
                akun.setAlamat(rs.getString("alamat"));
                akun.setUmur(rs.getInt("umur"));
                akun.setUniversitas(rs.getString("universitas"));

                User user = new User();
                user.setId(rs.getInt("app_users_id"));
                user.setEmail(rs.getString("app_users_email"));
                user.setPassword(rs.getString("app_users_pass"));

                akun.setUser_id(user);
                return akun;
            }
        });
    }

    public Integer create(AkunDto.Create akun) {
        String query = "INSERT INTO public.akun\n" +
                "(username, nama_lengkap, alamat, umur, universitas, app_users_id)\n" +
                "VALUES(:username, :nama_lengkap, :alamat, :umur, :universitas, :app_users_id);\n";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("username", akun.getUsername());
        map.addValue("nama_lengkap", akun.getNama_lengkap());
        map.addValue("alamat", akun.getAlamat());
        map.addValue("umur", akun.getUmur());
        map.addValue("universitas", akun.getUniversitas());
        map.addValue("alamat", akun.getAlamat());
        map.addValue("app_users_id", akun.getApp_users_id());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void update(AkunDto.Update akun) {
        String query = "UPDATE public.akun\n" +
                "SET username=:username, nama_lengkap=:nama_lengkap, alamat=:alamat, umur=:umur, universitas=:universitas, app_users_id=:app_users_id\n" +
                "WHERE id=:id;\n";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", akun.getId());
        map.addValue("username", akun.getUsername());
        map.addValue("nama_lengkap", akun.getNama_lengkap());
        map.addValue("alamat", akun.getAlamat());
        map.addValue("umur", akun.getUmur());
        map.addValue("universitas", akun.getUniversitas());
        map.addValue("app_users_id", akun.getApp_users_id());

        jdbcTemplate.update(query, map);

    }
}
