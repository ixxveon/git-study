package kr.co.koreait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex26_Exception {

	public static void main(String[] args) {
		try {
			int[] numbers = {1, 2, 3};
			System.out.println("예외 발생 전");
			numbers[3] = 10; // 발생했을 때 아래코드 실행 안하고 바로 catch로 감
			System.out.println("예외 발생 후");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생!!: " + e);  
		} finally {
			// 예외 발생 유무와 상관없이 실행할 코드
			System.out.println("Finally!");
		}
		
		System.out.println("끝");
		
		// --------------------------------
//		Scanner sc = new Scanner(System.in);
//		try(Scanner sc = new Scanner(System.in)) { // try-with-resources
//			System.out.print("첫번째 숫자: ");
//			int num1 = sc.nextInt();
//			
//			System.out.print("두번째 숫자: ");
//			int num2 = sc.nextInt();
//			
//			int result = num1/num2;
//			System.out.println("나눗셈 결과: " + result);
//			
//		} catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
//			System.out.println("발생한 예외: " + e);
////			e.printStackTrace();
////			System.out.println(e.getStackTrace()[0]);
////			System.out.println(e.getMessage());
//			
//		} finally {
////			sc.close();
//			System.out.println("프로그램 종료!");
//		}

		 
		// --------------------------------------------------------------------------------
		
		try {
			// throw는 의도적으로 예외 발생
			throw new ArrayIndexOutOfBoundsException();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생");
		}
		
		
		// --------------------------------------------------------------------------------
		try {
			readFile();
		} catch(IOException e) {
			System.out.println("파일을 찾을 수 없음");
		}
		
		// --------------------------------------------------------------------------------
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("나이: ");
			int age = sc.nextInt();
			
			checkAge(age);
		} catch(Ex26_2_CustomException e) {
			System.out.println("예외 발생: " + e);
		}
	}
	
	public static void checkAge(int age) {
		if(age < 0) {
			throw new Ex26_2_CustomException("나이는 음수가 될 수 없습니다!");
		} else if(age < 18) {
			throw new Ex26_2_CustomException("미성년자는 접근할 수 없습니다.");
		} else {
			System.out.println("정상적으로 접근되었습니다.");
		}
	}

	
	// -----------------------------------------------------------------------
	public static void readFile() throws IOException {
		// Checked Exception (예외 처리 필수)
		FileReader fr = new FileReader("test.txt");
	}
	
	
}
