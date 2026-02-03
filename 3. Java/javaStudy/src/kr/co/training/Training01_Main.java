package kr.co.training;

public class Training01_Main {

	public static void main(String[] args) {
//		1) Training01_Calc 클래스를 생성하세요.
//		- 매개변수 numbers의 모든 정수의 합을 반환하는 int sum() 메서드 생성
//		- 매개변수 numbers의 가장 큰 정수를 반환하는 int max() 메서드 생성
//		- 매개변수 numbers의 가장 작은 정수를 반환하는 int min() 메서드 생성
//	
//		2) 현재 메인 메서드에서 Training01_Calc 객체를 생성 후 sum, max, min 메서드를 호출하세요.
//		- 각각의 메서드에는 아래의 numbers 배열이 인자로 작성됩니다.
		int[] numbers = {50, 5, 8, 132, 15};
		
		Training01_Calc calc = new Training01_Calc();
		System.out.println(calc.sum(numbers));
		System.out.println(calc.max(numbers));
		System.out.println(calc.min(numbers));

	}
	

}
