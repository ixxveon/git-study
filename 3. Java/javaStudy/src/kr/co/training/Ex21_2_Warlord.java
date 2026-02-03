package kr.co.training;

// Character 클래스를 상속받습니다.
public class Ex21_2_Warlord extends Ex21_2_Character{
	
	
	// - 부모 생성자를 호출하세요.
	Ex21_2_Warlord(int str, int dex, int knowledge, int level) {
		super(str, dex, knowledge, level);
	}

	// attack 메서드 생성
	// - "둔기를 휘두릅니다" 출력
	void attack() {
		System.out.println("둔기를 휘두릅니다.");
	}
	
	// levelUp() 메서드 생성
	// - "레벨업을 하여 힘이 5 증가합니다." 출력
	// - "현재 레벨: 00, 힘: 00" 출력
	// - 현재 레벨을 1 증가시키고, 힘을 5 증가시킵니다.
	void levelUp() {
		super.setLevel(getLevel() + 1);
		super.setStr(getStr() + 5);
		System.out.println("레벨업을 하여 힘이 5 증가합니다.");
		System.out.printf("현재 레벨: %d, 힘: %d \n", getLevel(), getStr());
	}

}
