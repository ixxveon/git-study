package kr.co.training;

public class Training03_PremiumUser extends Training03_InternetUser{
//	2. Training03_PremiumUser 클래스를 생성하세요.
//	- Training03_InternetUser 클래스를 상속받습니다.
//	- 정수형 필드 membershipPeriod를 가집니다.
//		> 접근 제어자 : private
	private int membershipPeriod;
	
//	- 매개변수 3개(userName, email, membershipPeriod)를 가지는 생성자를 작성하세요.
//		> userName과 email은 부모 생성자를 호출하여 저장합니다.
//		> membershipPeriod는 현재 클래스의 필드에 저장합니다.
	Training03_PremiumUser(String userName, String email, int membershipPeriod) {
		super(userName, email);
		this.membershipPeriod = membershipPeriod;
	}
	
//	- 멤버십 기간을 출력하는 displayMembershipPeriod 메서드를 작성하세요.
//		> "멤버십 기간 : OO개월" 출력 
	void displayMembershipPeriod() {
		System.out.println("멤버십 기간: " + membershipPeriod + "개월");
	}
}
