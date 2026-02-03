package kr.co.training;

public class Ex21_Main {

	public static void main(String[] args) {
		System.out.println("=====주문=====");
		Ex21_1_Order order = new Ex21_1_Order();
		order.setNumber("ORDER3");
		order.setStatus("결제완료");
		order.setAmount(100);
		
		// =====================================================================
		// 객체 생성 시 힘50, 민첩10, 지력10, 레벨1로 생성
		System.out.println("=====캐릭터=====");
		Ex21_2_Warlord war = new Ex21_2_Warlord(50, 10, 10, 1);
		war.attack();
		war.levelUp();
		war.levelUp();
		
		// =====================================================================
		// 캐릭터의 능력치를 가진 객체
		Ex21_3_CharaterAbility ca = new Ex21_3_CharaterAbility();
		ca.setLevel(1);
		ca.setHp(100);
		ca.setMp(100);
		System.out.println(ca);
		
		ca.setHpPotionCount(10);
		ca.setMpPotionCount(10);
		
		// 소서리스 객체
		Ex21_3_Sorceress sorceress = new Ex21_3_Sorceress(ca);
		
		sorceress.skill(ca);
		System.out.println(ca);
		
		sorceress.attack(ca);
		System.out.println(ca);
		
		sorceress.skill(ca);
		System.out.println(ca);
		
		sorceress.skill(ca);
		System.out.println(ca);
		
		sorceress.skill(ca);
		System.out.println(ca);
		
		sorceress.levelUp(ca);
		System.out.println(ca);
		
		sorceress.mpPotion(ca);
		System.out.println(ca);
		
		sorceress.hpPotion(ca);
		System.out.println(ca);
		
	
	}

}
