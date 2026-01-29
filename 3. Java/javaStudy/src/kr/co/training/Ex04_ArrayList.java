package kr.co.training;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex04_ArrayList {

	public static void main(String[] args) {
		// Q1. 6의 배수만 리스트에 추가하세요
		//		- 리스트 이름: q1
		//		- 들어가는 값들의 타입은 숫자
		//		- 1~200사이의 6의 배수만 리스트 q1에 추가
		ArrayList<Integer> q1 = new ArrayList<>();
		for (int i=1; i<201; i++) {
			if (i % 6 == 0) {
				q1.add(i);
			}
		}
		System.out.println(q1);
		
		// Q2. 학생 정보를 저장히기 위한 ArrayList를 생성하세요.
		// - 프로그램을 아래와 같은 메뉴를 사용자로부터 입력받습니다.
		//		> "1. 학생 추가"
		//		> "2. 학생 목록 조회"
		//		> "3. 프로그램 종료"
		// - 1번 입력 시 사용자로부터 학생의 이름을 입력 받고 ArrayList에 추가
		// - 2번 입력 시 ArrayList에 저장된 모든 학생의 이름 출력
		// - 3번 입력 시 "프로그램을 종료합니다." 출력 후 종료
		// - 위의 프로그램은 사용자가 종료를 선택할 때까지 반복됩니다.
		// - 리스트 이름: student
		ArrayList<String> student = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=====학생 정보 프로그램=====");
			System.out.println("1. 학생 추가");
			System.out.println("2. 특정 학생 제거");
			System.out.println("3. 학생 목록 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호를 입력하세요: ");
			int num = sc.nextInt();
			
			if (num == 1) {
				System.out.print("추가할 학생 이름을 입력하세요: ");
				// next(): 공백기준
				// nextLine(): 엔터기준
				String num1 = sc.next();
				student.add(num1);
				 
			} 
			
			else if (num == 2) {
				// 학생 이름 받고 그 학생 제거
				System.out.print("삭제할 학생 이름을 입력하세요: ");
				String num2 = sc.next();
				for (int i=0; i<student.size(); i++) {
					if (num2.equals(student.get(i))) {
						student.remove(i);
					} 
				}
				
				
			} 
			
			else if (num == 3) {
				System.out.println("==학생목록==");
				for (int i=0; i<student.size(); i++) {
					System.out.println(student.get(i));
				}
			
			} 
			
			else if (num == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			
			else {
				System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}
		
		
	}
		
	

}
