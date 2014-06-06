package com.hugelist.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hugelist.entities.Manager;
import com.hugelist.services.ManagerService;
import com.hugelist.utils.Utils;


@Controller
//@RequestMapping("/management")
public class LoginController {

	@SuppressWarnings("deprecation")
	XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
			"SpringConfig.xml"));
	ManagerService managerService = (ManagerService) beanFactory
			.getBean("managerService");
	
	@RequestMapping(value="/")
	public ModelAndView printWelcome() {	    
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/default")
	public ModelAndView defaultPage(HttpSession session) {	  
		ModelAndView mav = new ModelAndView("default");
		session.setAttribute("menu_stt", "classification");
		return mav;
	}

	@RequestMapping("/logout")	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {	    
		for (Object name : Collections.list(session.getAttributeNames())) {
		    session.removeAttribute((String)name);
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		ModelAndView mav = new ModelAndView("login");

		Map params =  request.getParameterMap();
		String username = ((String[]) params.get("username"))[0];  
		String pass = ((String[]) params.get("pwd"))[0]; 

		username = username.trim();
		pass = pass.trim();

		if(username == null || username.equals(""))	{    
			mav.addObject("err_name", "* ");
			return mav;
		}
		else if(pass == null || pass.equals("")){  
			mav.addObject("err_pwd", "* ");
			return mav;
		}
		
		// check user exist
		List<Manager> managers = managerService.findByName(username);
		if (managers.size() == 0) {
			mav.addObject("err_name","Account corresponding with accountid doesn’t exist on HugeList");
		}
		
		Manager manager = managers.get(0);
		
		if (pass ==null || !manager.getPass().equals(pass)) {
			mav.addObject("err_pwd","The password isn't correct");
		}
		
		if(manager.getIsAdmin()) {
			
			manager = Utils.setAccountToken(manager);
			managerService.update(manager);
			
//			WAccount waccount = new WAccount(username, manager.getAid(), manager.getToken(), manager.getIsAdmin());
			
			session.setAttribute("user", manager);
			session.setAttribute("menuId", 0);
			
			mav.setViewName("default");
			mav.addObject("menu_stt", "classification");
		}
		
		return mav;
	}
}
