package com.kh.jdbc.day03.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day03.member.model.vo.Member;


public class MemberDAO {
	
	/**
	 * 회원 전체 정보 조회
	 * @param conn
	 * @return
	 */
	public List<Member> selectAll(Connection conn) { // 회원 전체 정보 조회
		List<Member> mList = null;
		String query = "SELECT * FROM MEMBER_TBL";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			mList = new ArrayList<Member>();
			// 후처리..
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				
				mList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mList;
	}
	
	/**
	 * 회원 아이도로 조회
	 * @param conn
	 * @return
	 */
	public Member selectOneById(Connection conn) {
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		ResultSet rset = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	/**
	 * 
	 */
	public int insertMember(Connection conn, Member member) {
		// Class.forName()
		// Connection conn = DriverMam\nager~~~
		int result = 0;
		String sql = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby()); // 쿼리문 실행 준비
			result = pstmt.executeUpdate(); // 쿼리문 실행
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 회원 정보 수정
	 * @param conn
	 * @param member
	 * @return
	 */
	public int updateMember(Connection conn, Member member) {	// 회원 정보 수정
		// UPDATE MEMBER_TBL SET MEMBER_PWD = ?,
		// MEMBER_EMAIL = ?, MEMBER PHONE = ?. MEMBER_HOBBY = ?, WHERE MEMBER_ID = ?
		String sql = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ? WHERE MEMBER_ID = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberHobby());
			pstmt.setString(6, member.getMemberId());	// 쿼리문 실행 준비 완료
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * 아이디로 조회 DAO
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(Connection conn, String memberId) {
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);//쿼리문 실행 준비 완료
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	/**
	 * 회원 이름으로 조회 DAO
	 * @param conn
	 * @param memberName
	 * @return
	 */
	public List<Member> selectAllByName(Connection conn, String memberName) {
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME LIKE ?"; // "%" 사용시 Like 중요!!!
		Member member = null;
		List<Member> mList = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" +memberName + "%");
			ResultSet rset = pstmt.executeQuery();
			mList = new ArrayList<Member>();
			while(rset.next()) {
				// 후처리!!
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				
				mList.add(member); // 상하차 중요!!!!!!!!
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	/**
	 * 회원 정보 삭제
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public int deleteMember(Connection conn, String memberId) {
		String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); 	// 쿼리문 실행준비 완료
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
}
