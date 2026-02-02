package kr.co.training;

public class Ex20_3_Member {

	// introduce 메서드
	// - Ex20_30_MemberInfo를 매개변수로 받습니다.
	// - "이름: "
	// - "나이: "
	// - "사는곳: "
	// - "학생여부: " (true면 학생, false면 학생 아님)
	public void introduce(Ex20_3_MemberInfo memberInfo) {
		String strStudent = memberInfo.getIsStudent() ? "학생" : "학생 아님";
		
		System.out.println("이름: " + memberInfo.getName());
		System.out.println("나이: " + memberInfo.getAge());
		System.out.println("사는곳: " + memberInfo.getAddr());
		System.out.println("학생여부: " + strStudent);
		
	}
	
	// run 메서드
	// - Ex20_3_MemberInfo를 매개변수로 받습니다.
	// "000에 사는 00이 달리고 있습니다." 출력
	public void run(Ex20_3_MemberInfo memberInfo) {
		System.out.println(memberInfo.getAddr() + "에 사는 " + memberInfo.getName() + "(이)가 달리고 있습니다.");
	}
	
}
