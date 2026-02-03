package kr.co.training;

public class Ex21_3_CharaterAbility {
	// 아래의 필드들을 가집니다.
	// - 힘(str), 민첩(dex), 지력(knowledge)
	//   레벨(level, 초기값 1)
	//   경험치(exp, 100이 될 경우 레벨이 1 증가하고 경험치는 0이 됨)
	//   체력(hp, 초기값 100, 레벨업을 해도 회복되지 않음)
	//   마력(mp, 초기값 100, 레벨업을 해도 회복되지 않음)
	// - 모든 필드의 접근 제어자는 private
	private int str;
	private int dex;
	private int knowledge;
	private int level;
	private int exp;
	private int hp;
	private int mp;
	
	// hpPotionCount, mpPotionCount 기본값 10
	private int hpPotionCount;
	private int mpPotionCount;
	
	// - 각 필드에 대한 getter/setter 작성
	public void setStr(int str) {
		this.str = str;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setExp(int exp) {
		// 경험치가 100 이상이면 레벨 1업, 초과하는 경험치 저장
		//	- 143 -> 1업하면 43 -> 43을 exp에 저장
		this.exp = exp;
		if(this.exp >= 100) {
			setLevel(getLevel() + 1);
			setExp(this.exp - 100);
		}
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public void setHpPotionCount(int hpPotionCount) {
		this.hpPotionCount = hpPotionCount;
	}
	public void setMpPotionCount(int mpPotionCount) {
		this.mpPotionCount = mpPotionCount;
	}
	
	public int getStr() {
		return str;
	}
	public int getDex() {
		return dex;
	}
	public int getKnowledge() {
		return knowledge;
	}
	public int getLevel() {
		return level;
	}
	public int getExp() {
		return exp;
	}
	public int getHp() {
		return hp;
	}
	public int getMp() {
		return mp;
	}
	public int getHpPotionCount() {
		return hpPotionCount;
	}
	public int getMpPotionCount() {
		return mpPotionCount;
	}
	
	// - 현재 능력치를 모두 확인할 수 있는 toString 오버라이팅 작성
	//		> toString은 문자열을 반환합니다.
	//		> public void toString() { return "문자열" }
	@Override
	public String toString() {
		return "힘: " + str + ", 민첩: " + dex + ", 지력: " + knowledge + 
				", 레벨: " + level + ", 경험치: " + exp + ", 체력: " + hp +
				", 마력: " + mp;
		// return String.format();
	}
}
