package com.bootcamp.jagadhita.backend.dao;


import com.bootcamp.jagadhita.backend.entity.User;
import com.bootcamp.jagadhita.backend.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRoleDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<UserRole> findAll() {
        String query = "SELECT id, \"role\"\n" +
                "FROM public.app_user_role;\n";

        return jdbcTemplate.query(query, new RowMapper<UserRole>() {
            @Override
            public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserRole role = new UserRole();
                role.setId(rs.getInt("id"));
                role.setRole(rs.getString("role"));

                return role;
            }
        });
    }
}
