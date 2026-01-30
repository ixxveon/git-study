package kr.co.koreait;

public class Ex18_2_Person {
	// 필드 선언만
	// 이름(name)
	// 나이(age)
	// 주소(addr)
	// 핸드폰번호(phone)
	String name;
	int age;
	String addr;
	String phone; 
	// 클래스 변수 (static 붙어있음)
	final static String HOBBY = "잠자기";
	
	// 이름하고 나이만 받는 생성자
	// - 주소랑 핸드폰 번호는 기본값을 지정해서 줌
	Ex18_2_Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.addr = "지구";
		this.phone = "아직 없음";
	}
	
	Ex18_2_Person(String name, int age, String addr, String phone) {
		System.out.println("생성자가 호출되었습니다.");
		// this: 필드로 감
		// - 객체 자기 자신
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
	}
	
//	Ex18_2_Person() {}
	
	// introduce 메서드
	// - "이름: 000"
	// - "나이: 000"
	// - "주소: 000"
	// - "핸드폰번호: 000"
	public void introduce() {
		System.out.println("ㅎㅇ");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("주소: " + addr);
		System.out.println("핸드폰번호: " + phone);
	
	}
}
