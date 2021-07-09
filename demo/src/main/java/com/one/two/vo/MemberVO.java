package com.one.two.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MemberVO {

	private int account_no;
	private String email;
	private String password;
	private String nickname;
	private int birth;
	private String age;
	private String gender;
	private String phone;
	private String country;
	private String city;
	private String indate;
	private String tag;

	/////////////////////////////
	private String memberEmail;
	private String code;
	private String phoneCountry;
	private String phoneNumber;
	private int phoneCode;
}
