package com.bootcamp.jagadhita.backend.dao;

import com.bootcamp.jagadhita.backend.dto.UserDto;
import com.bootcamp.jagadhita.backend.entity.User;
import com.bootcamp.jagadhita.backend.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String query = "SELECT app_users.id, app_users.email, app_users.\"password\", app_users.first_name,\n" +
                "app_users.last_name, app_users.username,\n" +
                "app_user_role.id as role_id,\n" +
                "app_user_role.\"role\" as role_name\n" +
                "FROM public.app_users app_users\n" +
                "left join app_user_role app_user_role on app_users.role_id = app_user_role.id;";

        return jdbcTemplate.query(query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setFirstName(rs.getString("last_name"));
                user.setFirstName(rs.getString("username"));

                UserRole role = new UserRole();
                role.setId(rs.getInt("role_id"));
                role.setRole(rs.getString("role_name"));

                user.setRole(role);
                return user;
            }
        });
    }

    public Integer create(UserDto.Create user) {
        String query = "INSERT INTO public.app_users\n" +
                "(email, \"password\", first_name, last_name, username, role_id)\n" +
                "VALUES(:email, :password, :first_name, :last_name, :username, :role_id);\n";

        MapSqlParameterSource map = new MapSqlParameterSource();

        map.addValue("email", user.getEmail());
        map.addValue("password", user.getPassword());
        map.addValue("first_name", user.getFirstName());
        map.addValue("last_name", user.getLastName());
        map.addValue("username", user.getUsername());
        map.addValue("role_id", user.getRole_id());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");

    }
}
