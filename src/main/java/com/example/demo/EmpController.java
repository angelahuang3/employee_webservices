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
		//List<Emp> session = (List<Emp>) request.getSession().getAttribute("save");
		//if (session == null) {
//			List<Emp> list = new ArrayList<Emp>();
////			emp.setId(3 + 1);
//			emp.setId(1);
//			list.add(emp);
//			session = list;
//		} else {
////			emp.setId(3 + session.size() + 1);
//			emp.setId(session.get(session.size() - 1).getId() + 1);
//			session.add(emp);
//		}
//		m.addAttribute("save", session);
		service.save(emp);  
		return "redirect:/viewemp";// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewemp")
	public String viewemp(HttpServletRequest request, Model m) {
//		List<Emp> list = new ArrayList<Emp>();
//		Emp emp1 = new Emp(); emp1.setId(1); emp1.setName("Peter"); emp1.setSalary(81000); emp1.setDesignation("Team Leader");
//		Emp emp2 = new Emp(); emp2.setId(2); emp2.setName("Tom"); emp2.setSalary(50100); emp2.setDesignation("Engineer");
//		Emp emp3 = new Emp(); emp3.setId(3); emp3.setName("John"); emp3.setSalary(100500); emp3.setDesignation("Manager");
//		list.add(emp1);
//		list.add(emp2);
//		list.add(emp3);
//		List<Emp> session = (List<Emp>) request.getSession().getAttribute("save");
//		if (session != null) {
//			for (Emp emp : session) {
//				list.add(emp);
//			}
//		}
     	List<Emp> list = service.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, HttpServletRequest request, Model m) {
		Emp emp = service.getEmpById(id);
//		Emp emp = new Emp();
//		emp.setId(1); emp.setName("Peter"); emp.setSalary(81000); emp.setDesignation("Team Leader");
//		List<Emp> session = (List<Emp>) request.getSession().getAttribute("save");
//		if (session != null) {
//			for (Emp e : session) {
//				if (e.getId() == id) {
//					emp = e;
//				}
//			}
//		}
		m.addAttribute("command", emp);
		return "empeditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("command") Emp emp, HttpServletRequest request, Model m) {
//		List<Emp> session = (List<Emp>) request.getSession().getAttribute("save");
//		if (session != null) {
//			for (Emp e : session) {
//				if (e.getId() == emp.getId()) {
//					e.setName(emp.getName());
//					e.setSalary(emp.getSalary());
//					e.setDesignation(emp.getDesignation());
//				}
//			}
//		}
		service.update(emp);
		return "redirect:/viewemp";
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, HttpServletRequest request) {
//		List<Emp> session = (List<Emp>) request.getSession().getAttribute("save");
//		if (session != null) {G
//			for (int i = 0; i < session.size(); i++) {
//				if (session.get(i).getId() == id) {
//					session.remove(session.get(i));
//					i--;
//				}
//			}
//		}
		dao.delete(id);
		return "redirect:/viewemp";
	}
}
