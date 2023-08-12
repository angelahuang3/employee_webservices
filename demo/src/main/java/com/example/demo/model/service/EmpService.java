package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Emp;
import com.example.demo.model.dao.EmpDao;
@Service
public class EmpService {
 @Autowired
 public EmpDao dao;
 //處理undo
 @Transactional
 public void save(Emp emp) {
	 dao.save(emp);
 }
 @Transactional(readOnly = true)
 public Emp getEmpById(int id) {
	 return dao.getEmpById(id);
 }
public List<Emp> getEmployees() {
	// TODO Auto-generated method stub
	return dao.getEmployees();
}
public void update(Emp emp) {
	// TODO Auto-generated method stub
	
}
public void delete(int id) {
	// TODO Auto-generated method stub
	
}
}
