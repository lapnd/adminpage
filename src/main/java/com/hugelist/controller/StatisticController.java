package com.hugelist.controller;

/*import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.viosoft.dt.model.Account;
import com.viosoft.dt.model.AccountStatistics;
import com.viosoft.dt.model.ContractStatistics;
import com.viosoft.dt.model.DownloadByDay;
import com.viosoft.dt.model.MessageByDay;
import com.viosoft.dt.ws.WSClient;
import com.viosoft.dt.ws.WSResult;*/

//@Controller
public class StatisticController {
//	/contractSttInfo
	/*@RequestMapping(value="/contractSttInfo")
	public ModelAndView redirectContractStatisticPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("logout");
		Account user = (Account) session.getAttribute("user");
		
		session.setAttribute("menuId", null);
		
		if(user == null)
			return mav;
		
		mav = new ModelAndView("contractstt");
		session.setAttribute("menu_stt", "statistic");
		
		int cYear =  Calendar.getInstance().get(Calendar.YEAR);
		//Get chart user info
		Object[] returns = WSClient.getInstance().getAllContractInfoByYear(user.getAID(), user.getToken(), 0, 1000, cYear);
		
		//System.out.println(returns[0]);
		
		String[] arrMonth =
			{"January", "February", "March","April","May","June","July","August","September","October","November","December"};
		String[] arrYear = {"2013"};
		
		if (returns.length >= 2){
			clearSession(session);
			
			List<ContractStatistics> contracts = (List<ContractStatistics>) returns[1];
			//sizeOfuserStt : for paging
			session.setAttribute("sizeOfItemStt", Integer.parseInt(returns[0].toString()));
			session.setAttribute("lstItemStt", contracts);
			
			List<String> month = new ArrayList<String>();
			List<String> year = new ArrayList<String>();
			
			Collections.addAll(month, arrMonth);
			Collections.addAll(year, arrYear);
			
			session.setAttribute("monthStt", month);
			session.setAttribute("yearStt", year);
			
			
		}
		
		return mav;
	}
//	userParamsSttInfo
	
	
	@RequestMapping(value="/userSttInfo")
	public ModelAndView redirectUserStatisticPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("logout");
		Account user = (Account) session.getAttribute("user");
		
		session.setAttribute("menuId", null);
		
		if(user == null)
			return mav;
		
		mav = new ModelAndView("userstatistic");
		session.setAttribute("menu_stt", "statistic");
		
		int cYear =  Calendar.getInstance().get(Calendar.YEAR);
		//Get chart user info
		Object[] returns = WSClient.getInstance().getAllUserInfoByYear(user.getAID(), user.getToken(), 0, 1000,cYear);
		
		//System.out.println(returns[0]);
		
		String[] arrMonth =
			{"January", "February", "March","April","May","June","July","August","September","October","November","December"};
		String[] arrYear = {"2013"};
		
		if (returns.length >= 2){
			List<AccountStatistics> accs = (List<AccountStatistics>) returns[1];
			clearSession(session);
			
			//sizeOfuserStt : for paging
			session.setAttribute("sizeOfItemStt", Integer.parseInt(returns[0].toString()));
			session.setAttribute("lstItemStt", accs);
			
			List<String> month = new ArrayList<String>();
			List<String> year = new ArrayList<String>();
			
			Collections.addAll(month, arrMonth);
			Collections.addAll(year, arrYear);
			
			session.setAttribute("monthStt", month);
			session.setAttribute("yearStt", year);
		}
		
		return mav;
	}
	
	private void clearSession(HttpSession session){
		session.removeAttribute("lstItemStt");
		session.removeAttribute("sizeOfItemStt");
		session.removeAttribute("nameStt");
		session.removeAttribute("varYearStt");
		session.removeAttribute("varMonthStt");
		session.removeAttribute("varID");
	}

	@RequestMapping(value = "/contractParamsSttInfo", method = RequestMethod.POST)  
	public @ResponseBody String contractParamsSttPage(@RequestParam("year") int year,
													   @RequestParam("month") int month,
													   HttpServletRequest request, 
													   HttpServletResponse response, 
													   HttpSession session) throws Exception {
		Account user = (Account) session.getAttribute("user");
		session.setAttribute("menuId", null);
		
		if(user == null)
			return "logout";

		Object[] returns = null;
		
		
		if(month != -1){
			Calendar c = Calendar.getInstance();
			c.set(year, month, 1);
			returns = WSClient.getInstance().getAllContractInfoByMonth(user.getAID(), user.getToken(), 0, 1000, c.getTime());
		}
		else 
			returns = WSClient.getInstance().getAllContractInfoByYear(user.getAID(), user.getToken(), 0, 1000, year);
		
		if (returns.length >= 2){
			clearSession(session);
			
			List<ContractStatistics> contracts = (List<ContractStatistics>) returns[1];
			//sizeOfuserStt : for paging
			session.setAttribute("sizeOfItemStt", Integer.parseInt(returns[0].toString()));
			session.setAttribute("lstItemStt", contracts);
			session.setAttribute("varYearStt", year);
			session.setAttribute("varMonthStt", month);
		}
		
		return "success"; 
	}
	
	@RequestMapping(value = "/userParamsSttInfo", method = RequestMethod.POST)  
	public @ResponseBody String userParamsSttPage(@RequestParam("year") int year,
													   @RequestParam("month") int month,
													   HttpServletRequest request, 
													   HttpServletResponse response, 
													   HttpSession session) throws Exception { 
		Account user = (Account) session.getAttribute("user");
		session.setAttribute("menuId", null);
		
		if(user == null)
			return "logout";

		Object[] returns = null;
		
		
		if(month != -1){
			Calendar c = Calendar.getInstance();
			c.set(year, month, 1);
			returns = WSClient.getInstance().getAllUserInfoByMonth(user.getAID(), user.getToken(), 0, 1000, c.getTime());
		}
		else 
			returns = WSClient.getInstance().getAllUserInfoByYear(user.getAID(), user.getToken(), 0, 1000,year);
		
		if (returns.length >= 2){
			
			List<AccountStatistics> accs = (List<AccountStatistics>) returns[1];
			clearSession(session);
			
			//sizeOfuserStt : for paging
			session.setAttribute("sizeOfItemStt", Integer.parseInt(returns[0].toString()));
			session.setAttribute("lstItemStt", accs);
			session.setAttribute("varYearStt", year);
			session.setAttribute("varMonthStt", month);
		}
		
		return "success";
	}
	@RequestMapping(value = "/showMessageContractStt", method = RequestMethod.POST)  
    public @ResponseBody String redirectMContractPage(@RequestParam("cid") String cid,
	    											  @RequestParam("year") int year,
	    											  @RequestParam("month") int month,
	    											  @RequestParam("name") String name,
	    											  HttpServletRequest request, 
	    											  HttpServletResponse response, 
	    											  HttpSession session) throws Exception { 
		
		Account user = (Account) session.getAttribute("user");
		session.setAttribute("menuId", null);
		
		if(user == null)
			return "logout";

		Object[] returns = null;
		if(month != -1){
			Calendar c = Calendar.getInstance();
			c.set(year, month, 1);
			returns = WSClient.getInstance().getNoOfMessageByContractByMonth(user.getAID(), user.getToken(), cid, c.getTime());
		}
		else 
			returns = WSClient.getInstance().getNoOfMessageByContractByYear(user.getAID(), user.getToken(), cid, year);
		
		if (returns.length >= 2){
			if ((WSResult)returns[0] == WSResult.OK){
				List<MessageByDay> messages = (List<MessageByDay>) returns[1];
				session.setAttribute("lstItemStt", messages);
				session.setAttribute("sizeOfItemStt", messages.size());
				session.setAttribute("nameStt", name.trim());
				session.setAttribute("varYearStt", year);
				session.setAttribute("varMonthStt", month);
				session.setAttribute("varID", cid);
			}
		}
		
		return "success";
	}
	
	@RequestMapping(value = "/showContractStt", method = RequestMethod.POST)  
    public @ResponseBody String redirectContractPage(@RequestParam("cid") String cid,
	    											  @RequestParam("year") int year,
	    											  @RequestParam("month") int month,
	    											  @RequestParam("name") String name,
	    											  HttpServletRequest request, 
	    											  HttpServletResponse response, 
	    											  HttpSession session) throws Exception { 
		
		Account user = (Account) session.getAttribute("user");
		session.setAttribute("menuId", null);
		
		if(user == null)
			return "logout";

		Object[] returns = null;
		if(month != -1){
			Calendar c = Calendar.getInstance();
			c.set(year, month, 1);
			returns = WSClient.getInstance().getNoOfDownloadByContractByMonth(user.getAID(), user.getToken(), cid, c.getTime());
		}
		else 
			returns = WSClient.getInstance().getNoOfDownloadByContractByYear(user.getAID(), user.getToken(), cid, year);
		
		if (returns.length >= 2){
			if ((WSResult)returns[0] == WSResult.OK){
				List<DownloadByDay> downloads = (List<DownloadByDay>) returns[1];
				session.setAttribute("lstItemStt", downloads);
				session.setAttribute("sizeOfItemStt", downloads.size());
				session.setAttribute("nameStt", name.trim());
				session.setAttribute("varYearStt", year);
				session.setAttribute("varMonthStt", month);
				session.setAttribute("varID", cid);
			}
		}
		
		return "success";
	}
	
	@RequestMapping(value = "/showMessageUserStt", method = RequestMethod.POST)  
    public @ResponseBody String redirectUserMessagePage(@RequestParam("aid") String aid,
		    											 @RequestParam("year") int year,
		    											 @RequestParam("month") int month,
		    											 @RequestParam("name") String name,
		    											 HttpServletRequest request, 
		    											 HttpServletResponse response, 
		    											 HttpSession session) throws Exception { 
		
		Account user = (Account) session.getAttribute("user");
		session.setAttribute("menuId", null);
		
		if(user == null)
			return "logout";

		Object[] returns = null;
		if(month != -1){
			Calendar c = Calendar.getInstance();
			c.set(year, month, 1);
			returns = WSClient.getInstance().getNoOfMessageByMonth(user.getAID(), user.getToken(), aid, c.getTime());
		}
		else 
			returns = WSClient.getInstance().getNoOfMessageByYear(user.getAID(), user.getToken(), aid, year);
		
		if (returns.length >= 2){
			if ((WSResult)returns[0] == WSResult.OK){
				List<MessageByDay> messages = (List<MessageByDay>) returns[1];
				session.setAttribute("lstItemStt", messages);
				session.setAttribute("sizeOfItemStt", messages.size());
				session.setAttribute("nameStt", name.trim());
				session.setAttribute("varYearStt", year);
				session.setAttribute("varMonthStt", month);
				session.setAttribute("varID", aid);
			}
		}
		
		return "success";
	}
	
	@RequestMapping(value="/usermessagestt")
	public ModelAndView redirectMessagePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("usermessagestt");
	}
	
	@RequestMapping(value="/contractddetailstt")
	public ModelAndView redirectContractPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("contractddetailstt");
	}
	
	@RequestMapping(value="/contractmdetailstt")
	public ModelAndView redirectMContractPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("contractmdetailstt");
	}
	
	@RequestMapping(value="/userRSttInfo")
	public ModelAndView redirectUsersttPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("userstatistic");
	}
	
	@RequestMapping(value="/contractRSttInfo")
	public ModelAndView redirectcontractsttPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("contractstt");
	}*/
//	contractmdetailstt
	/**
	@RequestMapping(value = "/getTypeDataC", method = RequestMethod.POST)  
    public @ResponseBody List<String> getTypeDataC(@RequestParam("type") String type,HttpServletResponse response, HttpSession session) throws Exception { 
		String[] arrMonth =
				{"January", "February", "March","April","May","June","July","August","September","October","November","December"};
		String[] arrYear = {"2013"};
		
		List<String> lst = new ArrayList<String>();
		
		if(type.equals("month"))
		{
			Collections.addAll(lst, arrMonth);
			return lst;
		}
		else if(type.equals("year")){
			Collections.addAll(lst, arrYear);
			return lst;
		}
		return null;
	}
	
	@RequestMapping(value = "/getTypeDataC", method = RequestMethod.POST)  
    public @ResponseBody List<String> getTypeDataC(@RequestParam("type") String type,HttpServletResponse response, HttpSession session) throws Exception { 
		String[] arr =
				{"January", "February", "March","April","May","June","July","August","September","October","November","December"};
		List<String> lst = new ArrayList<String>();
		
		Collections.addAll(lst, arr);
		
		if(type.equals("month"))
		{
			return lst;
		}
		return null;
	}
	*/
}
