package kr.co.koreait;

import java.util.Random;
import java.util.Scanner;

public class Ex05_for {

	public static void main(String[] args) {
		// for문
		// - 초기식, 조건식, 증감식으로 구성
		// - 반복할 횟수를 미리 알고 있을 경우에 사용
		for (int i=0; i<=100; i++) {
			System.out.println("i의 값: "+i);
		}
		
		// 문자열.length()를 사용하면 해당 문자열의 길이를 반환
		String subject = "Python";
		
		for (int i=0; i<subject.length(); i++) {
			System.out.println("subject for문 i의 값: "+ i);	
		}
		
		for (int i=10; i>0; i--) {
			System.out.println("i를 1씩 빼는 for문의 i 값: " + i);
		}
		
		// 사용자가 입력한 횟수만큼 반복하는 for문
		Scanner sc = new Scanner(System.in);
		System.out.println("반복할 횟수: ");
		int count = sc.nextInt();
		
		for (int i=0; i<count; i++) {
			System.out.println(i);
		}
		
		// 로또번호 생성하기
		Random rd = new Random();
		
		for (int i=0; i<6; i++) {
			int number = rd.nextInt(45)+1;
			System.out.print(number + " ");
		}
		
		for (int i=0; i<3; i++) {
			System.out.println("바깥 for문 i: " + i);
			
			for (int j=0; j<5; j++) {
				System.out.println("j: " + j);
			}
		}
	}

}
