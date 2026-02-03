package kr.co.training;

public class Training02_Main {

	public static void main(String[] args) {
//		2. 현재 메인 메서드에서 아래의 코드를 실행하여 결과를 확인하세요.
        // 직원 생성
        Training02_Employee jjangu = new Training02_Employee("짱구", "매니저", 4200);
        Training02_Employee jaeseop = new Training02_Employee("김재섭", "개발자", 7777);

        // 직원 정보 출력
        System.out.println("직원 짱구의 정보");
        jjangu.displayEmployeeInfo();
        System.out.println();

        System.out.println("직원 재섭의 정보");
        jaeseop.displayEmployeeInfo();
        System.out.println();

        // 연봉 인상
        jjangu.raiseSalary(700);
        System.out.println();

        // 인상된 연봉 출력
        System.out.println("직원 짱구의 정보 (인상 후)");
        jjangu.displayEmployeeInfo();


	}

}
