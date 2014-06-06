package com.hugelist.utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author vinhpq
 *
 */
public class HLMailSender {	
	private String content;
	private String title;
	Session session;
	String host = "smtp.gmail.com";
	String from = "hugelistviosoft";
	String pass = "abcde12345-";
	String port = "587";
	String protocol ="ssl";
	String protocolEnable = "mail.smtp.start"+ protocol + ".enable";
	Transport transport;
	
	public HLMailSender(String title, String content) {				
		this.content = content;
		this.title = title;
	}
	
	public boolean init(){
		Properties props = System.getProperties();
		props.put(protocolEnable, "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); 
		session = Session.getDefaultInstance(props, null);
		try {
			transport = session.getTransport("smtp");
			transport.connect(host, from, pass);

			return true;
			
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			
		}catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean close(){
		try {
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean sendGroupMail(String[] targetAddrList){		
		
		/*String host = "smtp.gmail.com";
	    String from = "hugelistviosoft@gmail.com";
	    String pass = "abcde12345-";*/
	    Properties props = System.getProperties();
	    props.put(protocolEnable, "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true"); 
	    
	   // String[] to = {target}; // added this line

	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[targetAddrList.length];

		    // To get the array of addresses
		    for( int i=0; i < targetAddrList.length; i++ ) { // changed from a while loop
		        toAddress[i] = new InternetAddress(targetAddrList[i]);
		       
		    }
		    System.out.println(Message.RecipientType.TO);

		    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
		        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		    }
		    message.setSubject(title);
		    message.setText(content);
		    Transport transport = session.getTransport("smtp");
		    transport.connect(host, from, pass);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();
		  
		} catch (AddressException e) {
			e.printStackTrace();
			//System.out.println("error." + e.getMessage());
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}

	    return true;
	}
	
	public boolean sendEmail(String targetAddr){		
		
		/*String host = "smtp.gmail.com";
	    String from = "hugelistviosoft";
	    String pass = "abcde12345-";*/
	    Properties props = System.getProperties();
	    props.put(protocolEnable, "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true"); 
	    
	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    try {
			message.setFrom(new InternetAddress(from));
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetAddr));
		    message.setSubject(title);
		    message.setContent(content,"text/html");
		    Transport transport = session.getTransport("smtp");
		    transport.connect(host, from, pass);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();		    
		} catch (AddressException e) {
			e.printStackTrace();
			
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			
			return false;
		}

	    return true;
	}
	
	
	public boolean sendEmailWithAttach(String to, String content, String fileAttachment){
		
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(title);
			
			// create the message part 
			MimeBodyPart messageBodyPart = new MimeBodyPart();

			//fill message
			messageBodyPart.setText(content);
			

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(fileAttachment);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileAttachment.split(File.separator)[fileAttachment.split(File.separator).length - 1]);
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);

			/*		// Send the message
				Transport.send( message );*/

			transport.sendMessage(message, message.getAllRecipients());
			
			return true;
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/*public static void main(String[] args){
//		String target[] = {"vinhpq177@gmail.com", "pham_quang_vinh1412@yahoo.com"};
		String target[] = {"vinhpq177@gmail.com"};
		String title = "Hello vinh. Your account is registered!";
		String content = "Click here to activate your account: www.vnexpress.net";
		
		
		
		*//** Build Register Email *//*
		HLMailSender sender = buildActivateMail();
		sender.sendEmail("vinhpq177@gmail.com");
		
		MailSender sender = new MailSender(title, content);
		sender.sendGroupMail(target);
		HLMailSender userReport = new DTMailSender("test from hugelistviosoft", "test content");
		userReport.sendEmail("vinhpq177@gmail.com");
		
		String content = "<p>Dear ";
//		content += a.getDerivaName() + ",\n";
		content += "Vinh" + ",</p>";
		content += "<p>Please find user usage report for last month on attached file.</p><p>Regards,</p>";
		
		HLMailSender userReport = new HLMailSender("hugelist user monthly report", content);
		userReport.sendEmail("vinhpq177@gmail.com");
//		userReport.sendEmail(emailList.get(0).getEmailAddress());
		
	}*/
	
	private static HLMailSender buildActivateMail(){
		String title = "Please verify your hugelist account";
		String url = "www.vnexpress.net";
		String content = "'<p>'.T_(\"Click the following link or copy and paste it into your browser address field to activate your account\").'</p>"
     	+ "<p><a href=\"'" + url + ".'\">'.T_(\"Confirm account\").'</a></p><p>'" + url + "'</p>'";
		
		return new HLMailSender(title, content);
	}
	
	 
	  /**
		 * send confirm reset password to user's mail address
		 * @param username
		 * @param sEmail
		 * @param lnkReset
		 * @return : true if send mail success
		 */
	  public static boolean sendMailActiveUser(String username, String sEmail, String lnkReset) {
			
		String title = "Welcome to Hugelist!";
		String message = 
				"<p>" + 
		"<span style=\"text-align: justify;\">Thank you for registering at Hugelist.</span></p>" +
		"<div style=\"text-align: justify;\">"+
			"&nbsp;</div>" +
		"<div>"+
		"&nbsp;</div>"+
	"<div style=\"text-align: justify;\">"+
		"Hugelist team.&nbsp;</div>";
		String content = "<table cellpadding='0' cellspacing='0' border='0' width='620'>"+ 
							"<tbody>"+  
								"<tr>  "+
									"<td style='background: #3b5998; font-weight: bold; vertical-align: middle; padding: 10px 8px;'>  "+
										"<a style='color: #ffffff; text-decoration: none;font-size: 15px;' href='#' target='_blank'>Hugelist</a>"+  
									"</td>"+ 
								"</tr> "+
								"<tr> "+
									"<td style='border-right: 1px solid #cccccc;  "+
											   "border-bottom: 1px solid #3b5998; "+ 
											   "border-left: 1px solid #cccccc; "+
											   "padding: 15px;font-size: 12px;font-weight: lighter;'>"+ 
										"<div style='margin-bottom: 15px;'>Hi " + username + ",</div> "+
										"<div style='margin-bottom: 15px'>" + message + "</div>"+ 			
										
									"</td>"+ 
								"</tr>"+ 
							"</tbody>"+ 
						"</table>"; 
		
		boolean process = false;
			
		HLMailSender sender = new HLMailSender(title, content);
		process = sender.sendEmail(sEmail);
		return (process);
	  }
	  
	
	  /**
		 * send confirm reset password to user's mail address
		 * @param username
		 * @param sEmail
		 * @param lnkReset
		 * @return : true if send mail success
		 */
	  public static boolean sendMailConfirmResetPassword(String username, String sEmail, String lnkReset, String expiredDate) {
			
		String title = "Hugelist: Request to retrieve your password!";

		String content = "<table cellpadding='0' cellspacing='0' border='0' width='620'>"+ 
							"<tbody>"+  
								"<tr>  "+
									"<td style='background: #3b5998; font-weight: bold; vertical-align: middle; padding: 10px 8px;'>  "+
										"<a style='color: #ffffff; text-decoration: none;font-size: 15px;' href='#' target='_blank'>Hugelist</a>"+  
									"</td>"+ 
								"</tr> "+
								"<tr> "+
									"<td style='border-right: 1px solid #cccccc;  "+
											   "border-bottom: 1px solid #3b5998; "+ 
											   "border-left: 1px solid #cccccc; "+
											   "padding: 15px;font-size: 12px;font-weight: lighter;'>"+ 
										"<div style='margin-bottom: 15px;'>Hi " + username + ",</div> "+
										"<div style='margin-bottom: 15px'>You made the request to retrieve your password on <a href='#'>Hugelist</a>. To finish retrieve your password, please click on the link below or copy and paste into your browser:</div>"+ 
										"<div style='margin-bottom: 15px; width: 95%; margin-top: 20px; font-family: LucidaGrande, tahoma, verdana, arial, sans-serif; padding: 10px; background-color: #fff9d7; border: 1px solid #e2c822;'> "+
											"<a href='" + lnkReset + "' style='color: #3b5998; text-decoration: none; font-weight: bold; font-size: 13px' target='_blank'>" + lnkReset + "</a>"+ 
										"</div> "+
										"<div style='margin-bottom: 15px;'>If you do not, please do NOT click on the link above.</div>"+
										"<div style='margin-bottom: 15px;color: red;font-weight: bold;'>This email is value to end on " + expiredDate + " (year / month / day hour:minute).</div>"+
										"<div style='margin-bottom: 15px; margin: 0'>Thanks &amp; Best Regards!<br>Hugelist System</div>"+ 
									"</td>"+ 
								"</tr>"+ 
							"</tbody>"+ 
						"</table>"; 
		
		HLMailSender sender = new HLMailSender(title, content);
		boolean process = sender.sendEmail(sEmail);
		
		return (process);
	  }
	  
	  /**
		 * send new password to user's mail address
		 * @param username
		 * @param sEmail
		 * @param password
		 * @return : true if send mail success
		 */
	  public static boolean sendMailPassword(String username, String sEmail, String password) {
			
		String title = "Hugelist System: Reset password!";

		String content = "<table cellpadding='0' cellspacing='0' border='0' width='620'>" +
				  "<tbody> " +
					"<tr> " +
						"<td style='background: #3b5998; font-weight: bold; vertical-align: middle; padding: 10px 8px;'> " +
							"<a style='color: #ffffff; text-decoration: none;font-size: 15px;' href='#' target='_blank'>Hugelist System</a> " +
						"</td>" +
					"</tr>" +
					"<tr>" +
						"<td style='border-right: 1px solid #cccccc;" + 
								   "border-bottom: 1px solid #3b5998; " +
								   "border-left: 1px solid #cccccc;" +
								   "padding: 15px;font-size: 12px;font-weight: lighter;'>" +
							"<div style='margin-bottom: 15px;'>Hi " + username + ",</div>" +
							"<div style='margin-bottom: 15px'>This is your new password:</div>" +
							"<div style='margin-bottom: 15px; width: 210px; margin-top: 20px; font-family: LucidaGrande, tahoma, verdana, arial, sans-serif; padding: 10px; background-color: #fff9d7; border: 1px solid #e2c822;'>" +
								"<b style='color: #3b5998; text-decoration: none; font-weight: bold; font-size: 13px'>" + password + "</b>" +
							"</div>" +
							"<div style='margin-bottom: 15px; margin: 0'>Thanks &amp; Best Regards!<br>Hugelist System</div>" +
						"</td>" +
					 "</tr>" +
					"</tbody>" +
				  "</table>" ;
		
		HLMailSender sender = new HLMailSender(title, content);
		boolean process = sender.sendEmail(sEmail);
		
		return (process);
	  }
	
}