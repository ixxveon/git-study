package kr.co.koreait;

public class aaa {

	public static void main(String[] args) {
		String[] names = {"김재섭", "홍길동", "짱구"};
		
	
		change(names);
		
		System.out.println(names[1]);

	}
	
	public static void change(String[] names) {
		names[1] = "세종대왕";
	}

}
