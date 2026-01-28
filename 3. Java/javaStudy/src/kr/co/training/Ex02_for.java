package kr.co.training;

public class Ex02_for {

	public static void main(String[] args) {
		// 1. 짝수를 출력하는 for문
		// - 범위: 1~20
		// - 해당 범위 안에 있는 짝수만 출력
		System.out.println("-----1번 문제-----");
		for (int i=1; i<21; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		// 2. 3과 5의 공배수를 출력하는 for문
		// - 범위: 1~100
		System.out.println();
		System.out.println("-----2번 문제-----");
		for (int i=1; i<101; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
		
		// 3. 10 팩토리얼의 값을 출력하는 for문
		// - 10 팩토리얼 = 1*2*3*4*5*6*7*8*9*10
		// - 값: 3628800
		System.out.println();
		System.out.println("-----3번 문제-----");
		int fact = 1;
		
		for (int i=1; i<11; i++) {
			fact *= i;
		}
		
		System.out.print(fact);
		
		// 4. 아래의 별찍기를 구현하세요.
		// *
		// **
		// ***
		// ****
		// *****
		// 별 1번, 엔터 1번
		// 별 2번, 엔터 2번, ... 
		System.out.println();
		System.out.println("-----4번 문제-----");
		int height = 5;
		for (int i=0; i<height; i++) {
			for (int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		// 2단부터 9단까지 출력하는 구구단 프로그램 만들기
		// 출력값: "2*1=2" "2*2=4" ... "2*9=18
		for (int i=2; i<10; i++) {
			for (int j=1; j<10; j++) {
				System.out.println  (i + "*" + j + "=" + i*j);
			}
		
		}
		
	}
}


