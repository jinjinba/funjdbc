package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {
	/**
	 * 학생 전체 목록 조회
	 * @return
	 */
	public List<Member> printAll() {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAll();
		return mList;
	}
	/**
	 * 아이디 조회
	 * @param memberId
	 * @return
	 */
	public Member printOneById(String memberId) {
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.selectOneById(memberId);
		return member;
	}
	/**
	 * 회원 로그인
	 * @param member
	 * @return
	 */
	public int checkInfo(Member member) {
		MemberDAO mDao= new MemberDAO();
		int result = mDao.checkLogin(member);
		return result;
	}
	
	/**
	 *  회원 등록
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(member);
		return result;
	}
	/**
	 * 회원 탈퇴
	 * @param memberId
	 * @return
	 */
	public int removeMember(String memberId) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}
	
	
	
	
	
	

}
