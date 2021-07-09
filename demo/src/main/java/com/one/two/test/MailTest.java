package com.one.two.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.one.two.service.CongratulationMailSender;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTest {
	
	@Autowired
	CongratulationMailSender sender;
	
	@Test
	public void congMailTest() {
		sender.authenticationSend("whitelaw7@naver.com");
	}

}
