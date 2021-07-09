package com.one.two.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SendSMSTwilio {

	// Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "AC566794ea09ed3996617212c950bc1518";
	  public static final String AUTH_TOKEN = "53653d689c9442d4405d4c66708d778c";
	  static int [] random = new int[1];
	  
	  public static int random1(int authNum) {
		  random[0] = authNum;
		  return random[0];
	  }
	  
	  public int random2() {
		  return random[0];
	  }
	  
	  // SMS 전송
	  @Autowired
	  public static int sendSMS (String country, String phoneNum) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    
	    // 휴대폰 인증번호 생성
	    int authNum = randomRange(100000, 999999);
	  	random1(authNum);
	    
	    // 전송대상 휴대폰 번호
	    String sendTarget = "+"+ country + phoneNum;
	    
	    // 전송 메세지
	    String authMsg = "Welcome, I AM GROOT! The authentication number is [" + authNum + "]" ;
	    
	    
	    Message message = Message.creator(
	    	// to
	    	new PhoneNumber("+821053768758"),
	        // from
	    	new PhoneNumber("+12056568644"), 
	        // message
	    	authMsg).create();
	    
		return authNum;
		
	  }
	    
	  // 인증번호 범위 지정
	  public static int randomRange(int n1, int n2) {
	    return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	  }
	  
	  
	}