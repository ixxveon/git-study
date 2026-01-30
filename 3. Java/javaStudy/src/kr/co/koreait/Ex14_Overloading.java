package kr.co.koreait;

public class Ex14_Overloading {

	public static void main(String[] args) {
		// 오버로딩 (Overloading)
		// - 같은 메서드 이름을 사용하지만 매개변수의 타입(자료형)과 위치가 다른 방식
		
		Ex14_Overloading intro = new Ex14_Overloading();
		intro.introduce("홍길동");
		intro.introduce("이가연", 20);
		Ex14_1_Calc calc = new Ex14_1_Calc();
		System.out.println(calc.add(10, 20));
		System.out.println(calc.add(10, 20, 30));
		
	}
	
	public void introduce(String name) {
		System.out.println("안녕하세요. 제 이름은 " + name + "입니다.");
	}
	
	public void introduce(String name, int age) {
		System.out.println("이름: " + name + ", 나이: " + age);
	}

}
