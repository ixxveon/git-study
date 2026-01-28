package kr.co.training;

import java.util.Scanner;

public class Ex03_Array {

	public static void main(String[] args) {
		
		System.out.println("-----1번문제-----");
		// 1. 5만큼의 길이를 가진 배열 arrString을 생성하세요.
		String[] arrString = new String[5];
		
		// 2. 위에서 생성한 배열을 아래의 값으로 초기화 하세요.
		//		-> "A", "B", "CD", "E" , "FG"
		arrString[0] = "A";
		arrString[1] = "B";
		arrString[2] = "CD";
		arrString[3] = "E";
		arrString[4] = "FG";
		
		// 3. 배열의 요소를 1개씩 꺼내서 꺼낸 요소가 "CD"일 경우 출력 후 반복문을 종료하세요.
		for(int i=0; i<arrString.length; i++) {
			System.out.println(arrString[i]);
			if("CD".equals(arrString[i])) {
				System.out.println("꺼낸 요소가 CD입니다. 반복문 종료");
				break;
			}
		}
		// ------------------------------------------------------------------
		System.out.println("-----2번문제-----");
		// 1. 사용자에게 입력받은 점수를 보관할 scores 배열을 생성하세요. (크기: 4)
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[4];
		int sum = 0;
		
		// 2. 인덱스별 점수는 아래와 같습니다.
		//		-> 0번 인덱스: 국어 점수
		//		-> 1번 인덱스: 영어 점수
		//		-> 2번 인덱스: 수학 점수
		//		-> 3번 인덱스: 과학 점수
		// String[] subjects = {"국어", "영어", "수학", "과학"};
		
		// 3. 사용자로부터 국어, 영어, 수학, 과학 점수를 입력받아 알맞은 배열의 위치에 할당하세요.
		for(int i=0; i<scores.length; i++) {
			System.out.print("점수를 입력하세요(국어/영어/수학/과학): ");
			//int input = sc.nextInt();
			scores[i] = sc.nextInt(); 
			sum += scores[i];
		}
		// 4. 배열에 있는 값의 합계 점수와 평균 점수를 출력하세요.
		System.out.print("합계 점수: " + sum + "점");
		System.out.println();
		System.out.print("평균 점수: "+ (sum / scores.length) + "점"); 
	}

}
