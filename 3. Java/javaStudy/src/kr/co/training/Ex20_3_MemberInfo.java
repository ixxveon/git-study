package kr.co.training;

public class Ex20_3_MemberInfo {
	// private 변수: name, age, addr, isStudent
	private String name;
	private int age;
	private String addr;
	private boolean isStudent;
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setIsStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	
	// getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
	public boolean getIsStudent() {
		return isStudent;
	}
	
}
