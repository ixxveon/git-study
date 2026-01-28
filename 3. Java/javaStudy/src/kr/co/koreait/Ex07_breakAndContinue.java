package kr.co.koreait;

import java.util.Scanner;

public class Ex07_breakAndContinue {

	public static void main(String[] args) {

		// continue
		// - 반복문의 처음으로 되돌아가는 예약어
		int count = 0;
		
//		while(count<10) {
//			System.out.println(count);
//			
//			if(count == 5) {
//				continue;
//			}
//			count++;
//		}
		
		for(int i=0; i<10; i++) {
			
			if(i%2 == 0) {
				System.out.println(i + "는 짝수입니다!");
				continue;
			}
			
			System.out.println(i + "는 홀수입니다!");
		}
		System.out.println("------------------------");
		// break문
		// - 반복문 종료
		for(int i=0; i<10; i++) {
			
			if(i%2 == 0) {
				System.out.println(i + "는 짝수입니다!");
				break;
			}
			
			System.out.println(i + "는 홀수입니다!");
		}
		
		// 숫자 맞추기
		int magicNumber = (int)(Math.random() * 30) + 1;
		Scanner sc = new Scanner(System.in);
		boolean isMatch = false; // 정답 유무
		
		for(int i=1; i<=10; i++) {
			System.out.print("숫자를 입력하세요: ");
			int guess = sc.nextInt();
			if (guess == magicNumber) {
				System.out.println(i+ "번째에 맞추셨습니다!");
				isMatch = true;
				break;
			} else if(guess > magicNumber) {
				System.out.println("맞춰야 할 숫자가 더 작습니다.");
			} else if(guess < magicNumber) {
				System.out.println("맞춰야 할 숫자가 더 큽니다.");
			}
			
			if (!isMatch) {
				System.out.println("숫자를 맞추지 못했습니다.");
				System.out.println("==========================");
			}
		}
		 
		
	}

}
