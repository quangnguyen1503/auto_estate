package com.autoestate.demo.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test-db")
    public String testConnection() {
        try {
            String dbName = jdbcTemplate.queryForObject("SELECT DATABASE()", String.class);
            return "✅ Kết nối MySQL thành công! Đang dùng DB: " + dbName;
        } catch (Exception e) {
            return "❌ Lỗi kết nối MySQL: " + e.getMessage();
        }
    }
}
