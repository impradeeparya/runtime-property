package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pradeep on 15/7/17.
 */

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/users")
    public String fetchUsers() {

        String query = "SELECT * FROM user where id = 1";

        User user = (User) jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<User>(User.class));

        return user.getName();
    }
}
