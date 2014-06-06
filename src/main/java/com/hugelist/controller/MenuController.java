package com.hugelist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hugelist.entities.Category;
import com.hugelist.entities.Classification;
import com.hugelist.entities.Manager;
import com.hugelist.services.AccountService;
import com.hugelist.services.CategoryService;
import com.hugelist.services.ManagerService;

@Controller
public class MenuController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml"); //$NON-NLS-1$
	AccountService accountService = (AccountService) this.context.getBean("accountService"); //$NON-NLS-1$
	ManagerService managerService = (ManagerService) this.context.getBean("managerService");
	CategoryService categoryService = (CategoryService) this.context.getBean("categoryService"); //$NON-NLS-1$
	
	/** TODO : Init function in start up page.
	@RequestMapping(value = "/initMenu", method = RequestMethod.GET)  
    public @ResponseBody void fetchFlowDowns(HttpServletResponse response, HttpSession session) throws Exception { 
		
		Account user = (Account) session.getAttribute("user");
		if(session.getAttribute("lstMenu")==null){
			List<ClassGroup3> lstMenu = WSClient.getInstance().getClassGroupsByAID(user.getAID(), user.getToken());
			session.setAttribute("lstMenu", lstMenu);
	        response.getWriter().write("true");
		}
		
	}
	*/
	

	/*@RequestMapping("/previewitem/{menuId}/{subMenuId}")
	public ModelAndView showPreviewPage(@PathVariable int menuId,  @PathVariable int subMenuId, HttpServletRequest request, ModelMap model,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("previewForm");
		Manager manager = (Manager) session.getAttribute("user");
		// Check authen
		if(manager==null)
			return new ModelAndView("logout");
		
		session.removeAttribute("lstItem");
		
		session.setAttribute("menuId", menuId);
		
		// Get left child menu data
		List<Cate> lstClass = WSClient.getInstance().getClassByGroupId(menuId);
		
		for (int i = 0; i < lstClass.size(); i++) {
			if(lstClass.get(i).getId() == subMenuId){				
//				session.setAttribute("currentCls",lstClass.get(i));
				modelAndView.addObject("className",lstClass.get(i).getName());				
				modelAndView.addObject("subMenuId",lstClass.get(i).getId());
				session.setAttribute("lstItem", lstClass.get(i).getItems());
			}
		}
		session.setAttribute("lstClass", lstClass);
		return modelAndView;
	}*/
	
	@RequestMapping(value = "/menu/{menuId}") 
	  public ModelAndView showMenu(@PathVariable String menuId, HttpServletRequest request, ModelMap model,HttpSession session) {
		
		Manager manager = (Manager) session.getAttribute("user");
		// Check authen
		if(manager == null)
			return new ModelAndView("logout");
		
		ModelAndView modelAndView = new ModelAndView("default");
		
		List<Category> lstMenu;
		
		lstMenu = categoryService.findByManagerAID(manager.getAid());

		if (lstMenu == null){
			return new ModelAndView("logout");//TODO
		}
		
		boolean is_valid_menu = false; 
		for (int i = 0; i < lstMenu.size(); i++) {
			if(lstMenu.get(i).getId() == menuId){
				session.setAttribute("menuName", lstMenu.get(i).getName());
				is_valid_menu = true;
				break;
			}
		}
		
		session.setAttribute("menuId", menuId);
		if(is_valid_menu==false && menuId != null && menuId != "")
			return new ModelAndView("error");
		
		session.setAttribute("lstClass", new ArrayList<Classification>());

		// Get left menu data
		session.setAttribute("lstMenu", lstMenu);
		
		// show menu items
		if(menuId == "")
			return modelAndView;
		
		// Get left child menu data
//		List<Classification> lstClass = WSClient.getInstance().getClassByGroupId(menuId);
		
		session.setAttribute("lstClass", lstMenu.get(0).getClassifications());
		modelAndView.setViewName("classification");
		return modelAndView;
	  }
	
	  /*@RequestMapping(value = "/menu2/{menuId}/{subMenuId}") 
	  public ModelAndView showMenu2(@PathVariable int menuId, @PathVariable int subMenuId, HttpServletRequest request, ModelMap model,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("classItem");
		Account user = (Account) session.getAttribute("user");
		// Check authen
		if(user==null)
			return new ModelAndView("logout");
		
		session.removeAttribute("lstItem");
		
		session.setAttribute("menuId", menuId);
		
		// Get left child menu data
		List<Classification2> lstClass = WSClient.getInstance().getClassByGroupId(menuId);
		
		if(lstClass == null)
			return new ModelAndView("error");
		
		boolean is_valid_menu = false;
		for (int i = 0; i < lstClass.size(); i++) {
			if(lstClass.get(i).getId() == subMenuId){
				session.setAttribute("currentCls",lstClass.get(i));
				is_valid_menu = true;
				break;
			}
		}
		
		if(is_valid_menu == false)
			return new ModelAndView("error");
		
		session.setAttribute("lstClass", lstClass);
		return modelAndView;
	}*/
}
