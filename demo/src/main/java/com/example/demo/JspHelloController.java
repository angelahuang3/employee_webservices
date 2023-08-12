package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class JspHelloController {
   private String message="我的第一個JSP頁面";
   @GetMapping({"/","/hello"})
   public String hello(Model model) {
	   model.addAttribute("message", message);
	   return "hello";
   }
}
