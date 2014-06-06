package com.hugelist.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hugelist.client.entities.SharedAccount;
import com.hugelist.entities.Account;
import com.hugelist.entities.Manager;

public class Utils {
	
	  public static final int sessionHourTime = 72; 
	
	  public static String RandomString(){
		SecureRandom random = new SecureRandom();  
		String str = new BigInteger(130, random).toString(32);  
		return (str);
	  }
	  
	  public String getDateString(Date date){
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(date);
		}
	  
	  public static String getTomorowDateTime(){
			
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			
			String today = sdf.format(date);
			String tomorow = "";
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(today));
				c.add(Calendar.DATE, 1);  // number of days to add
				tomorow = sdf.format(c.getTime());  // dt is now the new date
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println(tomorow);		
			return tomorow;
		}
		
	  public static boolean compareExpiredDate(String dateTarget){
			
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date dtCurrent = new Date();
			Date dtTarget = null;		
			boolean result = false;
			
			try {
				dtTarget = (Date) sdf.parse(dateTarget);
				// Compare date return true if Current date before or equal with Target date
				if(dtTarget.compareTo(dtCurrent) < 0)
					result = false;
				else 
					result = true;
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return result;
		}
	  
	  public static boolean isTokenExpired(Account account){
		  Date current = new Date();
		  if(account.getSessionExpired().before(current))
		   return true;
		  
		  return false;

	  }
	  public static Manager setAccountToken(Manager manager){
			if(manager == null){			
				return null;
			}
			String token = generateRandomMD5(16);
			
			manager.setToken(token);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, sessionHourTime);
			Date date = cal.getTime();
			manager.setSessionExpired(date);
			return manager;
	  }
	  
	  public static String generateRandomMD5(int lenght){
			IdGenerator ig = new IdGenerator();
			return ig.generateId(lenght);
	}
	  
	  public static Account setValueAccount(Account account, SharedAccount saccount){
	  
		  return account;
	  }
	  
	  public static SharedAccount setValueShareAccount(Account account){
		  
		  SharedAccount saccount = new SharedAccount();
		  
		  return saccount;
	  }
	  
	  /**
	   * Account Name lenght should > 3 characters
	   * Contains only: A-Z, a-z, 0-9, "_", "."
	   * @param str
	   * @return
	   */
	  public static boolean validateAccountName(String str){
	   if(str==null || str.trim().equals(""))
	    return false;
	   //String PATTERN = "^[_A-Za-z0-9-]";
	   //String PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)";
	   String PATTERN = "[a-zA-Z0-9._-]{3,}";

	   Pattern  pattern;
	   Matcher matcher;  
	   pattern = Pattern.compile(PATTERN);
	   matcher = pattern.matcher(str);  
	   return matcher.matches();
	  }
	  
	  /**
	   * Pass should be > 5 characters
	   * Require including digit, uppercase, lower case, ignore special symbol 
	   * @param str
	   * @return
	   */
	  public static boolean validatePassword(String str){
	   if(str==null || str.trim().equals("")){
	    
	    return false;
	   }
	    
	   //String PATTERN =    "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{5,})";
	   String PATTERN =    "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,})";

	   Pattern  pattern;
	   Matcher matcher;  
	   pattern = Pattern.compile(PATTERN);
	   matcher = pattern.matcher(str);
	   return matcher.matches();
	  }
	  
}
