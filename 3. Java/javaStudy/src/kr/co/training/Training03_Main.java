package kr.co.training;

public class Training03_Main {

	public static void main(String[] args) {
//		3. 메인 메서드에서 Training03_PremiumUser 객체를 생성하세요.
//		- displayUserInfo, displayMembershipPeriod 메서드를 호출하여 결과를 확인하세요.
		Training03_PremiumUser premium = new Training03_PremiumUser("이가연", "ixxveon@gmail.com", 2);
		premium.displayUserInfo();
		premium.displayMembershipPeriod();

	}

}
