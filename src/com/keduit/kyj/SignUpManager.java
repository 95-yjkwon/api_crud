package com.keduit.kyj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignUpManager {
	private List<Member> memberList;
	private Scanner scanner;

	public SignUpManager() {
		memberList = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void signUp() {

		System.out.println("아이디를 입력하세요:");
		String username = scanner.nextLine();
		System.out.println("비밀번호를 입력하세요:");
		String password = scanner.nextLine();

		Member newMember = new Member(username, password);
		memberList.add(newMember);
		System.out.println("회원가입이 완료되었습니다.");
	}

	public boolean login(String username, String password) {
		for (Member member : memberList) {
			if (member.getusername().equals(username) && member.getpassword().equals(password)) {
				return true;
			}

		}
		return false;

	}

	public void displayMembers() {
		System.out.println("===== 회원 목록 =====");
		for (Member member : memberList) {
			System.out.println("아이디: " + member.getusername());
			System.out.println("비밀번호: " + member.getpassword());
			System.out.println("--------------------");
		}
	}

	public static void main(String[] args) {
		SignUpManager signUpManager = new SignUpManager();

		// 회원 가입
		signUpManager.signUp();
		// 회원 목록 출력
		signUpManager.displayMembers();
	}

}
