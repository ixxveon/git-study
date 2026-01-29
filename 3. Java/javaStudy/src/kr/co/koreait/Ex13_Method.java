package kr.co.koreait;

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
		
		System.out.println(result); 
		System.out.println(m.printHello("하이"));
		
		Ex13_1_Calc calc = new Ex13_1_Calc();
		int result1 = calc.add(5, 3);
		System.out.println(result1);
		
		calc.add(10, 10);
		calc.add(10, 20);  
		
		System.out.println("뺄셈: " + calc.sub(30, 20, 10));
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
