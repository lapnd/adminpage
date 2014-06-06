package com.hugelist.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hugelist.client.entities.WSResult;
import com.hugelist.entities.Account;
import com.hugelist.entities.Manager;
import com.hugelist.services.AccountService;
import com.hugelist.services.ManagerService;
import com.hugelist.utils.Common;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class TestController {
	
	@SuppressWarnings("deprecation")
	XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
			"SpringConfig.xml"));
	ManagerService managerService = (ManagerService) beanFactory
			.getBean("managerService");
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Locale locale, Model model) {
		
		// Check and create admin information
		List<Manager> managers = managerService.findByName(Common.ADMIN_NAME);

		if (managers.size() == 0) {
			Manager admin = new Manager();
			String uuid = UUID.randomUUID().toString();
			admin.setId(uuid);
			admin.setAid(uuid);
			admin.setIsAdmin(true);
			
			managerService.insert(admin);
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
