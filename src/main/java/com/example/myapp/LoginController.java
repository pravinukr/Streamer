package com.example.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.UserService;
import com.example.myapp.User;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/home")
	public String loginadmin(HttpServletRequest request) {
		//request.setAttribute("mode", "MODE_LOGINADMIN");
		return "/web-inf/views/signin.jsp";
	}
	@PostMapping("/logged-in")
	public String login(@ModelAttribute User user, HttpServletRequest request) {
		//User user = null;
		//System.out.println("mapped");
		if(userService.find(user.getUsername(), user.getPassword())) {
			//request.setAttribute("Successfully logged in", "Successfully logged in");
			return "/web-inf/views/signin.jsp";
		}
		else {
			request.setAttribute("error", "You are not an admin");
			//request.setAttribute("mode", "MODE_LOGINADMIN");
			return "/web-inf/views/demo.jsp";
			
		}
	}

}
