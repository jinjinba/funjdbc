package com.kh.jdbc.day01.student.model.vo;

import java.sql.Date;

public class Student {
	private String studentId; // STUDENT_ID -> studentId
	private String studentName; // STUDENT_NAME -> studentName
	private String studentPwd;
	private int age;
	private String email;
	private String phone;
	private String gender;
	private String address;
	private String hobby;
	private Date enrollDate; // ENROLL_DATE -> enrollDate;
	
	// 생성자
	public Student() {}
	
	public Student(String studentId) {
		this.studentId = studentId;
	}
	
	public Student(String studentId, String studentName, String studentPwd, int age, String email, String phone,
			String gender, String address, String hobby, Date enrollDate) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPwd = studentPwd;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	
	// getter/setter
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPwd() {
		return studentPwd;
	}
	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	// tostring
	public String getStudentId() {
		return studentId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPwd=" + studentPwd
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", address="
				+ address + ", hobby=" + hobby + ", enrollDate=" + enrollDate + "]";
	}
}
