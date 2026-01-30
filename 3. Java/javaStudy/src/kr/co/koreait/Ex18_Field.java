package kr.co.koreait;

public class Ex18_Field {
	// 필드
	int num = 10; // 인스턴스 변수
	
	public static void main(String[] args) {
		// 필드 (=멤버 변수)
		// - 클래스 레벨의 변수를 의미
		int num2 = 20;
		
		// stack: 변수가 올라감
		// heap: 실제 값(배열)
		// static: static이 붙은 클래스 변수
		// static: 공통 되는 데이터들을 저장  
		
		// -----------------------------------------------
		Ex18_1_Car car = new Ex18_1_Car();
		car.wheel = 5;
		
		System.out.println(car.speed);
		System.out.println(car.wheel);
		
		Ex18_1_Car sonata = new Ex18_1_Car();
		sonata.wheel = 7;
		sonata.speed = 140;
		
		System.out.println(sonata.speed);
		System.out.println(sonata.wheel); 
		
		// -------------------------------------------
//		Ex18_2_Person minsu = new Ex18_2_Person();
//		minsu.name = "민수";
//		minsu.age = 15;
//		minsu.addr = "인천";
//		minsu.phone = "010-1234-1234";
//		minsu.introduce();
		
		Ex18_2_Person jjanggu = new Ex18_2_Person("신짱구", 5, "떡잎마을", "없음");
		jjanggu.introduce();
		
//		jjanggu.name = "짱구";
//		jjanggu.age = 5;
//		jjanggu.addr = "떡잎마을";
//		jjanggu.phone = "010-1111-1111";
		
		System.out.println(Ex18_2_Person.HOBBY);
		
		Ex18_2_Person hindoong = new Ex18_2_Person("흰둥이", 3);
		hindoong.introduce();
		
		
		
		
	}

}
