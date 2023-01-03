package com.kh.jdbc.day03.member.model.vo;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.day03.member.model.dao.MemberDao;

public class MemberService {
	
//	private JDBCTemplate jdbcTemplate;
	private MemberDao mDao;		
	
	public MemberService() {
//		jdbcTemplate = JDBCTemplate.getDriverLoad();
		mDao = new MemberDao();		// 생략하지 말기!
	}
	/**
	 * 회원 전체 조회 Service
	 * @return LIst<Member>
	 */
	public List<Member> selectAll() {
		List<Member> mList = null;
//		MemberDAO mDao = new MemberDAO();
//		JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad();
		Connection conn = JDBCTemplate.getConnection();
		mList = mDao.selectAll(conn);
//		JDBCTemplate.close(conn);
//		conn.close();
		return mList;
	}
	/**
	 * 회원 아이디로 조회 Service
	 * @param member
	 * @return
	 */
	public Member selectOneById(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = mDao.selectOneById(conn, memberId);
//		JDBCTemplate.close(conn);
		return member;
	}
	/**
	 * 회원 이름으로 조회 Service
	 * @param memberName
	 * @return List<Member>
	 */
	public List<Member> selectAllByName(String memberName) {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> mList = mDao.selectAllByName(conn, memberName);
		return mList;
	}
	/**
	 * 회원 가입 Service
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
//		MemberDAO mDao = new MemberDAO();
//		JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad();
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
//		JDBCTemplate.close(conn);
		return result;
	}
	/**
	 * 회우너 정보 수정 Service
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.updateMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
//		JDBCTemplate.close(conn);
		return result;
	}
	/**
	 * 회원 정보 삭제 Service
	 * @param memberId
	 * @return
	 */
	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.deleteMember(conn, memberId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	
	
	
	
	
	
}
