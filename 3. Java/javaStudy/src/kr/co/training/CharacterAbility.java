package kr.co.training;

public class CharacterAbility {
//	1. 힘(str), 민첩(dex), 지력(knowledge)
//	- 기본값 : 0
	private int str;
	private int dex;
	private int knowledge;
	
//  2. 레벨(level)
//  - 기본값 : 1
	private int level = 1;
	
//  3. 경험치(experience)
//  - 기본값 : 0
//  - 특징 : 경험치가 100 이상이 될 경우 레벨이 1 증가하고 경험치는 0으로 초기화됩니다.
	private int experience;
	
//  4. 체력(hp), 마력(mp)
//  - 기본값 : 100
//  - 특징 : 레벨업을 해도 회복되지 않습니다. 포션을 사용해도 최대 100까지만 회복됩니다.
	private int hp = 100;
	private int mp = 100;
	
//  5. 잔여 스텟(unusedStatus)
//  - 기본값 : 0
//  - 특징 : 레벨업을 하면 5가 추가됩니다.
	private int unusedStatus;
	
//  6. 소지중인 체력 포션(hpPortionCount), 마력 포션(mpPortionCount)
//  - 기본값 : 10
	private int hpPortionCount = 10;
	private int mpPortionCount = 10;
	
	// setter
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
	public void setExperience(int experience) {
	//  - 특징 : 경험치가 100 이상이 될 경우 레벨이 1 증가하고 경험치는 0으로 초기화됩니다.
		this.experience = experience;
		if (getExperience() >= 100) {
			setLevel(getLevel() + 1);
			setExperience(0);
		}
	}
	public void setHp(int hp) {
	//  - 특징 : 레벨업을 해도 회복되지 않습니다. 포션을 사용해도 최대 100까지만 회복됩니다.
		this.hp = hp;
		if (getHp() > 100) {
			setHp(100);
		}
	}
	public void setMp(int mp) {
	//  - 특징 : 레벨업을 해도 회복되지 않습니다. 포션을 사용해도 최대 100까지만 회복됩니다.
		this.mp = mp;
		if (getMp() > 100) {
			setMp(100);
		}
	}
	public void setUnusedStatus(int unusedStatus) {
		this.unusedStatus = unusedStatus;
	}
	public void setHpPortionCount(int hpPortionCount) {
		this.hpPortionCount = hpPortionCount;
	}
	public void setMpPortionCount(int mpPortionCount) {
		this.mpPortionCount = mpPortionCount;
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
	public int getExperience() {
		return experience;
	}
	public int getHp() {
		return hp;
	}
	public int getMp() {
		return mp;
	}
	public int getUnusedStatus() {
		return unusedStatus;
	}
	public int getHpPortionCount() {
		return hpPortionCount;
	}
	public int getMpPortionCount() {
		return mpPortionCount;
	}

	
}
