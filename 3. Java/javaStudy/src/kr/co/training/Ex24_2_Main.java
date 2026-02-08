package kr.co.training;

import java.util.Scanner;

public class Ex24_2_Main {

	public static void main(String[] args) {
//		사용자로부터 아이디와 비밀번호를 입력받으세요.
		Scanner sc = new Scanner(System.in);
		System.out.printf("아이디: \n");
		String id = sc.next();
		System.out.printf("비밀번호: \n");
		String pw = sc.next();
		
//		아래 클래스들을 모두 구현 후 login 메서드를 호출하세요.
//		    > 사용자가 입력한 아이디와 비밀번호를 인자값으로 전달해주어야 합니다.
//		    > 반환받은 값을 result 변수에 저장 후 출력합니다.
		// 인터페이스는 객체 생성못함!!
		Ex24_2_LoginInterface login = new Ex24_2_Login();
		String result = login.login(id, pw);
		System.out.println(result);
		
		
		
	






	}

}
