package com.example.demo;

import java.awt.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Emp;
import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.model.dao.EmpDao;
import com.example.demo.model.dao.LoginDao;
import com.example.demo.model.dao.UserDao;
import com.example.demo.model.service.EmpService;

@Controller
@SessionAttributes("save")
public class LoginController {
	@Autowired
	private LoginDao dao;
	@Autowired
	private UserDao userdao;

	@RequestMapping(value = "/loginform")
	public String showform(Model m) {
		m.addAttribute("command", new Login());
		return "loginform";
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST) // 接
	public String checklogin(@ModelAttribute("login") Login login, HttpServletRequest request, Model m) {
		Login sqlob = new Login();
		sqlob = dao.getpermission(login.getAccount());

		if ("-1".equals(sqlob.getAccount())) {
			return "redirect:/loginfail";
		} else if ((sqlob.getPassword()).equals(login.getPassword())) {
			System.out.print("success");
			m.addAttribute("save", login.getAccount());// add session
			return "redirect:/viewlogin";
		} else {
			System.out.println("account or password is incorrect");
			return "redirect:/loginfail";
		}
	}

	@RequestMapping("/viewlogin")
	public String viewlogin(Model m, HttpServletRequest request) {
		String session = (String) request.getSession().getAttribute("save");// 傳出session
		Login getdata = dao.getpermission(session);// dao.permission是傳帳號過去，回傳Login()
		m.addAttribute("getdata", getdata);// 在viewlogin頁面丟一個login()

		java.util.List list = userdao.getusers();
		m.addAttribute("list", list);
		return "viewlogin";

	}
	
	@RequestMapping("/loginfail")
	public String loginfail() {
		return "loginfail";
	}
}
