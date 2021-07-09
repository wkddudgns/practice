package com.one.two.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.one.two.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession session;
	
	public int memberJoin(MemberVO member) {
		int cnt = 0;
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		try {
			cnt = mapper.memberJoin(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public MemberVO selectOne(String email) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		MemberVO member = null;
		try {
			member = mapper.selectOne(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

}
