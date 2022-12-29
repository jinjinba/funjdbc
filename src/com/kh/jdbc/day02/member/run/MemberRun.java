package com.kh.jdbc.day02.member.run;

import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.model.vo.Member;
import com.kh.jdbc.day02.member.view.MemberView;

public class MemberRun {
	public static void main(String[] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		Member member = null;
		List<Member> mList = null;
		String studentId = "";
		String studentName = "";
		int result = 0;
		
		goodbye :
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 0 : break goodbye;
			case 1 :
				// 1. 회원 전체 조회
				mList = mCon.printAll();
				if (!mList.isEmpty()) {
					mView.showAll(mList);
				}else {
					mView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 2 : break;
			case 3 : break;
			case 4 :
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.displaySuccess("가입이 완료되었습니다.");
				}else {
					mView.displayError("가입 실패하였습니다.");
				}
				break;
			case 5 : break;
			case 6 : break;
			default : break;
			}
		}
	}
}
