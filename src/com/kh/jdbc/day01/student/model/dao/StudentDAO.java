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
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public List<Student> selectAll() {

		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "STUDENT";
		String PASSWORD = "STUDENT";
		String sql = "SELECT * FROM STUDENT_TBL";
		Student student = null;
		List<Student> sList = null;
		try {
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
				// 택배 상차
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
	
	public List<Student> selectAllByName(String studentName) {
		List<Student> sList = null;
		Student student = null;
		// 쿼리문 작성
		String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME = '"+studentName+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>();
			while(rset.next()) {
				student = new Student();
				// setter
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
				// 택배 상차
				sList.add(student);
				
				// 후처리
			}
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
	
	public Student selectOneById(String studentId) {
		Student student = null;
		String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_ID = '"+studentId+"'";
		try {
			
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			// 2. DB연결 객체 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. Statement 생성, 쿼리문 실행준비 완료
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 5. 결과 받기
			ResultSet rset = stmt.executeQuery(sql); //셀렉트 는 쿼리
			//stmt.executeLargeUpdate(sql);    // DML 은 update를 써서 인트를 받음
			// 후처리
			if(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			// 6. 자원 해제
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
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
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML(INSERT, UPDATE, DELETE)
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
	
	public int deleteMember(String studentId) {
		int result = 0;
		String sql = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID = '"+ studentId +"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// DML (INSERT, UPDATE, DELETE) -> 중요 시험 : executeUpdate -> int!!!!!!
			result = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		// Void methods cannot return a value
	}
	
	public int updateStudent(Student student) {
		int result = 0;
		String sql = "UPDATE STUDENT_TBL SET "
				+ "STUDENT_PWD = '" + student.getStudentPwd() + "', "
					+ "EMAIL = '" + student.getEmail() + "', "
						+ "PHONE = '" + student.getPhone() + "', "
							+ "ADDRESS = '" + student.getAddress() + "', "
								+ "HOBBY = '" + student.getHobby() +"' "
									+ "WHERE STUDENT_ID = '" + student.getStudentId() + "'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
