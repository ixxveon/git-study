package kr.co.training;

public class Training02_Employee {
//	1. Training02_Employee 클래스를 생성하세요.
//	- 문자열 필드 name, position과 실수형 필드 salary를 가집니다.
//		> 접근 제어자 : private
	private String name;
	private String position;
	private float salary;
	
//	- 매개변수 3개(name, position, salary)를 가지는 생성자를 작성하세요.
//		> 각각의 매개변수를 필드에 저장합니다.
	Training02_Employee(String name, String position, float salary) {
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
//	- 연봉을 인상하는 raiseSalary 메서드를 작성하세요.
//		> 실수형 increaseAmount 매개변수를 가집니다.
//		> 현재 연봉(salary)과 인상 금액(invreaseAmount)을 더한 금액을 필드 salary에 저장하세요.
	public void raiseSalary(float increaseAmount) {
		salary += increaseAmount;
	}
	
//	- 직원 정보를 출력하는 displayEmployeeInfo 메서드를 작성하세요.
//		> "=====직원 정보====="
//		> "이름 : OOO"
//		> "직급 : OOO"
//		> "연봉 : OOO만원"
//		> "================="
	public void displayEmployeeInfo() {
		System.out.println("=====직원 정보=====");
		System.out.println("이름: " + name);
		System.out.println("직급: " + position);
		System.out.println("연봉: " + salary);
		System.out.println("=====직원 정보=====");
	}
}
