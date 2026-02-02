package kr.co.koreait;

public class Ex20_getterSetter {

	public static void main(String[] args) {
		Ex20_1_Person kim = new Ex20_1_Person();
		
		kim.setAge(10);
		kim.setName("김철수");
		kim.setAddr("인천");
		kim.setIsStudent(true);
		
		System.out.println(kim.getAge());
		System.out.println(kim.getName());
		System.out.println(kim.getAddr());
		System.out.println(kim.getIsStudent());
		
	}

}
