package kr.co.koreait;

import java.util.Scanner;

public class Ex13_Method {

	public static void main(String[] args) {
		// 메서드
		// - 정의된 동작이나 기능을 수행
		
		// 객체 생성 (=인스턴스화)
		// - 코드를 메모리에 올리는 과정
		// - 클래스명 변수명 = new 클래스명();
		
		// 클래스 전체에 있는 코드가 메모리에 올라감
		Ex13_Method m = new Ex13_Method();
		String result = m.printHello("안녕하세요 저는 홍길동입니다.");
		
		// ------------------------------------------------------------
		System.out.println("=====Person 메서드=====");
		Ex13_2_Person p = new Ex13_2_Person();
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = sc.next();
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		System.out.println(p.introduce(name, age));
		System.out.println(p.sayAge(24)); 
		
		// -------------------------------------------------------------
		System.out.println("=====BankAccount 메서드=====");
		Ex13_3_BankAccount bank = new Ex13_3_BankAccount();
		int deposit = bank.deposit(100000);
		System.out.println(deposit + "원을 입금했습니다.");
		
		int withdraw = bank.withdraw(10000);
		System.out.println(withdraw + "원을 출금했습니다.");

		int checkBalance = deposit - withdraw;
		System.out.println(bank.checkBalance());
		System.out.println("현재 잔액: "+ checkBalance);
		
		
		// ------------------------------------------------
		System.out.println(result); 
		
		int[] numbers = {100, 200, 300, 400};
		
		System.out.println("=====Calc 메서드=====");
		Ex13_1_Calc calc = new Ex13_1_Calc();
		int result1 = calc.add(5, 3);
		int sum = calc.sum(numbers);
		
		System.out.println(result1);
		System.out.println(sum);
		
		calc.add(10, 10);
		calc.add(10, 20);  
		
		//System.out.println("뺄셈: " + calc.sub(30, 20, 10));
		System.out.println("곱셈: " + calc.mul(10, 10, 10, 10));
		System.out.println("나눗셈(나머지): " + calc.div(10, 2));
	}
	
	// 안녕하세요 출력하는 메서드
	// public 반환타입 메서드명(자료형 매개변수명) {   }
	// - 반환 타입의 종류: void, int, String, int[], ArrayList, ...
	// - void: 반환 타입 없음(return 없음)
	public String printHello(String str) {
		System.out.println(str);
		return "잘 출력되었습니다.";
	}
	

}
