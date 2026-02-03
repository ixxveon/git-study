package kr.co.koreait;

public class Ex23_Poly {

	public static void main(String[] args) {
		// 부모 클래스 타입으로 객체 생성 (평소 방식)
		Ex23_1_Parent parent = new Ex23_1_Parent();
		parent.printHello();
		
		
		// 자식 클래스 타입으로 객체 생성 (평소 방식)
		Ex23_1_Child child = new Ex23_1_Child();
		child.printHello();
		child.displayHello();
		
		//  Ex23_1_Parent p = child; // 클래스 타입 변환
		
		
		// 클래스 타입 변환 (자식 객체를 부모 타입으로)
		// - 부모 클래스에 있는 변수와 메서드만 사용 가능
		Ex23_1_Parent p = new Ex23_1_Child();
		p.printHello();
		
		// Calendar에 있는 메소드들 출력(예시: 리모컨)
		// hanging()이 있는데 오버라이딩 된 걸로 출력(덮어 씀)
		Ex23_2_Calendar calendar = new Ex23_2_DeskCalendar("빨강", 8);
		calendar.info();
		// 오버라이딩한 결과 출력
		calendar.hanging();
//		calendar.onTheDesk();
		
		// ===========================================================
		
		Ex23_3_ComputerRoom cr = new Ex23_3_ComputerRoom();
		cr.computer1 = new Ex23_3_Samsong();
		cr.computer2 = new Ex23_3_Samsong();
		cr.computer3 = new Ex23_3_Samsong();
		
		cr.computer1 = new Ex23_3_LZ();
		cr.computer2 = new Ex23_3_LZ();
		cr.computer3 = new Ex23_3_LZ();
		
		cr.allPowerOn();
		
	}

}
