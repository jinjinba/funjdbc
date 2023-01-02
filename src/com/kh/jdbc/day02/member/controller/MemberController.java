package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {
	/**
	 * 학생 전체 목록 조회
	 * @return
	 */
	public List<Member> printAll() {	//SELECT * FROM MEMBER_TBL
//		public 반환형 printAll(매개변수) {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAll();
		return mList;
	}
	/**
	 * 아이디 조회
	 * @param memberId
	 * @return
	 */
	public Member printOneById(String memberId) {	// SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
		// ResultSet이 1개면 Member
		// ResultSet이 1개 이상이면 List<Member>!!!!!!!!!!!!!!!!!!
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.selectOneById(memberId);
		return member;
	}
	
	/**
	 * 이름으로 조회
	 * @param memberName
	 * @return
	 */
	public List<Member> printOneByName(String memberName) {	// SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME = ?
		// ResultSet이 1개면 Member
		// ResultSet이 1개 이상이면 List<Member>!!!!!!!!!!!!!!!!!!
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectOneByName(memberName);
		return mList;
	}
	/**
	 * 회원 로그인
	 * @param member
	 * @return
	 */
	public int checkInfo(Member member) {	// SELECT * FROM MEMBER_ID = ? AND MEMBER_PWD = ?
		MemberDAO mDao= new MemberDAO();
		int result = mDao.checkLogin(member);
		return result;
	}
	
	
	/**
	 *  회원 등록
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {	// UNSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(member);
		return result;
	}
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @return
	 */
	public int modifyMemberInfo(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member);
		return result; // return 0으로 두지 않아요!!!!
	}

	/**
	 * 회원 탈퇴
	 * @param memberId
	 * @return
	 */
	public int removeMember(String memberId) {	// DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}
	
	
	

}
