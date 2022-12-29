package com.kh.jdbc.day01.student.controller;

import java.util.List;

import com.kh.jdbc.day01.student.model.dao.StudentDAO;
import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentController {
		/**
		 * 학생 전체 목록 조회
		 * @param studentName
		 * @return
		 */
		public List<Student> printAll() {
			StudentDAO sDao = new StudentDAO();
			List<Student> sList = sDao.selectAll();
			return sList;
		}
		/**
		 * 학생 이름으로 조회
		 * @param studentName
		 * @return
		 */
		public List<Student> printAllByName(String studentName) {
			StudentDAO sDao = new StudentDAO();
			List<Student> sList = sDao.selectAllByName(studentName);
			return sList;
		}
		/**
		 * 학생 아이디로 조회
		 * @param studentId
		 * @return
		 */
		public Student printOneById(String studentId) {
			StudentDAO sDao = new StudentDAO();
			Student student = sDao.selectOneById(studentId);
			return student;
		}
		
		/**
		 * 회원 등록
		 * @param student
		 * @return
		 */
		public int registerStudent(Student student) {
			StudentDAO sDao = new StudentDAO();
			int result = sDao.insertMemver(student);
			return result;
		}
		/**
		 * 
		 * @param studentId
		 * @return
		 */
		public int removeStudent(String studentId) {
			StudentDAO sDao = new StudentDAO();
			int result = sDao.deleteMember(studentId);
			return result;
			// Void methods cannot return a value
		}
		/**
		 * 
		 * @param student
		 * @return
		 */
		public int modifyStudent(Student student) {
			StudentDAO sDao = new StudentDAO();
			int result = sDao.updateStudent(student);
			return result;
		}
		
		
		
		
		
		
		
		
}
