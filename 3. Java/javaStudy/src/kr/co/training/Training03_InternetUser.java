package kr.co.training;

public class Training03_InternetUser {
//	1. Training03_InternetUser 클래스를 생성하세요.
//	- 문자열 필드 userName과 email을 가집니다.
//		> 접근 제어자 : private
	private String userName;
	private String email;
	
//	- 매개변수 2개(userName, email)을 가지는 생성자를 작성하세요.
//		> 각각의 매개변수를 필드에 저장합니다.
	Training03_InternetUser(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}
	
//	- 사용자 정보를 출력하는 displayUserInfo 메서드를 작성하세요.
//		> "=====사용자 정보====="
//		> "이름 : OOO"
//		> "이메일 : OOO@OOOO.com"
//		> "=================="
	void displayUserInfo() {
		System.out.println("=====사용자 정보=====");
		System.out.println("이름 : " + userName);
		System.out.println("이메일 : " + email);
		System.out.println("==================");
	}

}
