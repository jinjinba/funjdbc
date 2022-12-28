package com.kh.jdbc.day01.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentDAO {

	public List<Student> selectAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STUDENT";
		String password = "STUDENT";
		String sql = "SELECT * FROM STUDENT_TBL";
		Student student = null;
		List<Student> sList = null;
		try {
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(url, user, password);
			// 3. 쿼리문 실행준비(Statement 생성)
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및 결과 받기
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>();
			// 후처리
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setAge(rset.getInt("AGE")); // 얘만 Int 시험일 수도
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setGender(rset.getString("GENDER"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE")); //
				sList.add(student);
				
				
//				System.out.println("ID : " 			 + rset.getString("STUDENT_ID")); // 필드값!!
//				System.out.println("STUDENT_NAME : " + rset.getString("STUDENT_NAME")); // 필드값!!
//				System.out.println("STUDENT_PWD : "  + rset.getString("STUDENT_PWD")); // 필드값!!
//				System.out.println("AGE : " 		 + rset.getString("AGE")); // 필드값!!
//				System.out.println("GENDER : " 		 + rset.getString("GENDER")); // 필드값!!
//				System.out.println("ADDRESS : " 	 + rset.getString("ADDRESS")); // 필드값!!
			}
			// 6. 자원해제
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	
	public int insertMemver(Student student)	{
//		// 데이터는 이미 준비 되었음
//		Student student = new Student();
//		student.setStudentId("khuser02");
//		student.setStudentName("이용자");
//		student.setStudentPwd("pass02");
//		student.setAge(22);
//		student.setGender("M");
//		// 데이터 준비 완료
		
		// 1. 드라이버 등록
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "STUDENT";
		String password = "STUDENT";
		
//		String sql = "INSERT INTO STUDENT_TBL VALUES('"+student.getStudentId()+"','"+student.getStudentPwd()+"','"+student.getStudentName()+"','"+student.getGender()+"',"+student.getAge()+",'khuser03@naver.com','01088320393','서울시 동대문구','자전거,축구',SYSDATE)";
		String sql = "INSERT INTO STUDENT_TBL VALUES("
				+ "'"+student.getStudentId()+"',"
					+ "'"+student.getStudentPwd()+"',"
						+ "'"+student.getStudentName()+"',"
							+ "'"+student.getGender()+"',"
								+student.getAge()+","
									+ "'"+student.getEmail()+"',"
										+ "'"+student.getPhone()+"',"
											+ "'"+student.getAddress()+"',"
												+ "'"+student.getHobby()+"',"
													+ "SYSDATE)";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML(INSERT, UPDATE, DELETE
			/////////////시험문제/////////////////
			result = stmt.executeUpdate(sql); // dml의 경우 int 
			//////////////위에 시험문제 ///////////////////
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
