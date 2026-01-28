package kr.co.koreait;

import java.util.Scanner;

public class Ex06_while {

	public static void main(String[] args) {
		// while문
		// - 조건식으로 구성됨
		int cnt = 0;
		
		// while문을 사용할 땐 언젠가 조건식이 false가 나오도록 해주어야 함
		// - 안그러면 영원히 반복되는 무한 루프가 발생
		while (cnt < 5) {
			System.out.println("현재 cnt 값: " + cnt);
			cnt++;
		}
		
		// while문으로 합계 구하기
		int sum = 0; // 합계를 저장할 변수
		int count = 1; // while문 조건식에 줄 변수
		
		// 1부터 10까지의 합계
		while (count<11) {
			sum += count;
			count++;
		}
		System.out.println("1부터 10까지의 합계: " + sum);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("0을 입력하면 종료됩니다: ");
		int inputExit = sc.nextInt();
		
		while(inputExit !=0) {
			System.out.print("0을 입력하세요: ");
			inputExit = sc.nextInt();
		}
		
		// do-while문
		// - 조건식과 상관없이 최초 1번은 무조건 실행
		// - 참, 거짓을 판단하기 전에 무조건 1번 이상 실행해야 할 코드가 있을 경우 사용
		
		// while문: 조건 검사 -> 코드 실행
		// do-while문: 코드 실행(do) -> 조건 검사
		int num;
		do {
			System.out.print("0 입력: ");
			num = sc.nextInt();
		} while(num != 0);
		
		
	}

}
