package com.one.two.dao;

import com.one.two.vo.MemberVO;

public interface MemberMapper {
	
	public int memberJoin(MemberVO member);
	public MemberVO selectOne(String email);

}
