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
	// @Autowired
	// public EmpService service;
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
	// 接值用接到值的account去撈資料庫的物件的account比對
	public String checklogin(@ModelAttribute("login") Login login, HttpServletRequest request, Model m) {
		Login sqlob = new Login();
		sqlob = dao.getpermission(login.getAccount());

		if ("-1".equals(sqlob.getAccount())) {
			return "redirect:/loginfail";
		} else if ((sqlob.getPassword()).equals(login.getPassword())) {
			System.out.print("正確");
			m.addAttribute("save", login.getAccount());// 丟入session
			return "redirect:/viewlogin";
		} else {
			System.out.println("帳號密碼錯誤");
			return "redirect:/loginfail";
		}
//		String password =dao.getpassword(login);
//	//String session=(String)request.getSession().getAttribute("save");
//	if(password==login.getPassword()) {
//	}
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