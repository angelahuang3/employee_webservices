package com.example.demo.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public java.util.List getusers() {
		String query = "SELECT * FROM user";
		java.util.List list = jdbcTemplate.query(query, new BeanPropertyRowMapper(User.class));
		return list;
	}
}
