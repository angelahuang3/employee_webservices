package com.example.demo.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Emp;
import com.example.demo.model.Login;
@Repository
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
//	public void save(Login login) {
//		String query = "INSERT INTO login(account, password, permission) VALUES (?, ?, ?)";
//		jdbcTemplate.update(query, login.getAccount(),login.getPassword(), login.getPermission());
//	}
//	public List<Login> getEmployees() {
//		String query = "SELECT * FROM login";
//		List<Login> list = jdbcTemplate.query(query, new BeanPropertyRowMapper(Login.class));
//		return list;
//	}
	public Login getpermission(String account) {
		String query = "SELECT * FROM login where login.account=?";
		Login value=new Login();
		Login error=new Login();
		try {
			value=(Login)jdbcTemplate.queryForObject(query,new Object[] {account},new BeanPropertyRowMapper(Login.class));
		}catch(Exception e) {
			return error;
		}
		return value;
		//return (String) jdbcTemplate.queryForObject(query, new Object[] { login.getAccount() }, new BeanPropertyRowMapper(Login.class));
	}
//	public String  getpermission(Login login) {
//		String query = "SELECT account FROM login where account=?";
//		return login.getAccount();
//	}
	
		
}
