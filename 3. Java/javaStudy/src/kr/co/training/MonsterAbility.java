package kr.co.training;

public class MonsterAbility {
//	1. 데미지(damage)
//	- 기본값 : 5
//	2. 체력(hp)
//	- 기본값: 100
	private int damage = 5;
	private int hp = 100;
	
//	3. getter/setter 작성
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getDamage() {
		return damage;
	}
	public int getHp() {
		return hp;
	}
}
