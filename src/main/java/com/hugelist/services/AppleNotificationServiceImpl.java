package com.hugelist.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.PayloadBuilder;

public class AppleNotificationServiceImpl implements NotificationService{
	private static final Logger logger = LoggerFactory.getLogger(AppleNotificationServiceImpl.class);

	static String certification=System.getProperty("user.home").concat("/HugeListServer/server/data/iphone_production.p12"); 

	//static boolean mode = false; //mean sandbox
	static boolean mode = true; //mean production
	static String password="hugelist3p@ssword";
	ApnsService service;
	
	private static volatile AppleNotificationServiceImpl instance = null;

	public static AppleNotificationServiceImpl getInstance() {
		System.out.println("Key Path=" + certification);
		logger.info(certification);
		
		if (instance == null) {
			synchronized (AppleNotificationServiceImpl.class) {
				// Double check
				if (instance == null) {
					instance = new AppleNotificationServiceImpl(certification,mode,password);
				}
			}
		}
		return instance;
	}
	
	public AppleNotificationServiceImpl(String cert,boolean mode, String password){
		init(cert,mode,password);
	}
	
	
	
	public void init(String cert,boolean mode, String password){
		
		certification = cert;
		this.mode = mode;
		this.password = password;
		
		System.out.println("===============");
		System.out.println(certification);
		System.out.println("===============");
		
		if(mode){
			//production
			service = APNS.newService().withCert(certification, password).withProductionDestination().build();			
			
		}else{
			//development
			service = APNS.newService().withCert(certification, password).withSandboxDestination().build();
		}
	}

	@Override
	public void sendMesage(String device, String message,String sound) {
		// TODO Auto-generated method stub
		//String sound = "ring-ring.aiff";
		//String token = "e05c3542d835c4b8f64abe89137a4fcdab69b17da4fa9fd03bd67508d3bc6c4d";
		final PayloadBuilder payloadBuilder = APNS.newPayload();
		payloadBuilder.alertBody(message);
		payloadBuilder.sound(sound);
		String payload = payloadBuilder.build();
		service.push(device, payload);	
	}
	
}
