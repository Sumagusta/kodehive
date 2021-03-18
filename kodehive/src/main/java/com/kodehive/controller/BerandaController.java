package com.kodehive.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BerandaController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/beranda")
	public String beranda() {
		String html = "beranda";
		//String path = env.getProperty("urlInsta");
		return html;
	}
	
	
	@RequestMapping("/login/action")
	public String tujuan(HttpServletRequest request, Model model) {
		String mintaUser = request.getParameter("username"); 				// data dari nilai yang ada di username diberikan ke mintaUser
		
		model.addAttribute("userLempar", mintaUser); 						// value yang ada di mintaUser, diberikan ke userLempar
		String home = "beranda";
		return home;
	}
}
