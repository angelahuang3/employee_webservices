 package com.example.demo.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Emp emp) {
		String query = "INSERT INTO emp(name, salary, designation) VALUES (?, ?, ?)";
		jdbcTemplate.update(query, emp.getName(), emp.getSalary(), emp.getDesignation());
	}

	public List<Emp> getEmployees() {
		String query = "SELECT * FROM emp";
		List<Emp> list = jdbcTemplate.query(query, new BeanPropertyRowMapper(Emp.class));
		return list;
	}

	public Emp getEmpById(int id) {
		String query = "SELECT * FROM emp WHERE id=?";
		return (Emp) jdbcTemplate.queryForObject(query, new Object[] { id }, new BeanPropertyRowMapper(Emp.class));
	}

	public void update(Emp emp) {
		String query = "UPDATE emp SET name=?, salary=?, designation=? WHERE id=?";
		jdbcTemplate.update(query, new Object[] { emp.getName(), emp.getSalary(), emp.getDesignation(), emp.getId() });
	}

	public void delete(int id) {
		String query = "DELETE FROM emp WHERE id=?";
		jdbcTemplate.update(query, id);
	}

}
