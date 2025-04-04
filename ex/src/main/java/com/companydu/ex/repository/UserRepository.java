package com.companydu.ex.repository;

import com.companydu.ex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM userss", new UserRowMapper());
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM userss WHERE id = ?",
            new UserRowMapper(),
            id
        );
    }

    public void save(User user) {
        if (user.getId() == null) {
            jdbcTemplate.update(
                "INSERT INTO userss (name, email, phone) VALUES (?, ?, ?)",
                user.getName(), user.getEmail(), user.getPhone()
            );
        } else {
            jdbcTemplate.update(
                "UPDATE userss SET name = ?, email = ?, phone = ? WHERE id = ?",
                user.getName(), user.getEmail(), user.getPhone(), user.getId()
            );
        }
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM userss WHERE id = ?", id);
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone")
            );
        }
    }
} 