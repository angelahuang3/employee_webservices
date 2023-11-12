package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Emp;
import com.example.demo.model.dao.EmpDao;
import com.example.demo.model.service.EmpService;


@Controller
@SessionAttributes("save")
public class EmpController {
    @Autowired
    public EmpService service;
	@Autowired
	public EmpDao dao;

	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Emp());
		return "empform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Emp emp, HttpServletRequest request, Model m) {
		service.save(emp);  
		return "redirect:/viewemp";// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewemp")
	public String viewemp(HttpServletRequest request, Model m) {
     		List<Emp> list = service.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, HttpServletRequest request, Model m) {
		Emp emp = service.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("command") Emp emp, HttpServletRequest request, Model m) {
		service.update(emp);
		return "redirect:/viewemp";
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, HttpServletRequest request) {		
		dao.delete(id);
		return "redirect:/viewemp";
	}
}
