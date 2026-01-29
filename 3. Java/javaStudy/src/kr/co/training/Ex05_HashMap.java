package kr.co.training;

import java.util.HashMap;
import java.util.Scanner;

public class Ex05_HashMap {

	public static void main(String[] args) {
		
		// "이름": "전화번호" 형태의 phoneBook이라는 HashMap을 생성
		HashMap<String, String> phoneBook = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("1. 전화번호 추가");
			System.out.println("2. 전화번호 검색");
			System.out.println("3. 전화번호 전체 검색");
			System.out.println("4. 전화번호 삭제");
			System.out.println("0. 프 로그램 종료");
			System.out.print("메뉴 입력: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			// 1번 입력 시
			// - 사용자로부터 이름과 전화번호를 입력받습니다.
			// - 입력받은 이름을 키로, 전화번호를 값으로 phoneBook에 저장
			// - "000의 전화번호를 추가했습니다." 출력
			if (menu == 1) {
				System.out.print("추가할 이름: ");
				String name = sc.next();
				System.out.print("추가할 전화번호: ");
				String phone = sc.next();
				phoneBook.put(name, phone);
				System.out.println(name + "의 전화번호를 추가했습니다.");
			}
			
			// 2번 입력 시
			// - 사용자로부터 검색할 이름을 입력받습니다.
			// - phoneBook에 일치하는 이름이 있다면
			//		> "000의 전화번호는 000-0000-0000 입니다." 출력
			// - phoneBook에 일치하는 이름이 없다면
			//		> "000의 전화번호를 찾을 수 없습니다." 출력
			else if (menu == 2) {
				System.out.print("검색할 이름: ");
				String name = sc.next();
					if (phoneBook.containsKey(name)) {
						System.out.println(name + "의 전화번호는 " + phoneBook.get(name) + " 입니다.");
					} else {
						System.out.println(name + "의 전화번호를 찾을 수 없습니다.");
					}
				
			}
			
			// 3번 입력 시
			// - phoneBook에 존재한 모든 목록을 출력
			//		> "이름: 000, 전화번호: 000-0000-0000"
			else if (menu == 3) {
				System.out.println("==전화번호 목록==");
				System.out.println(phoneBook);
			}
			
			// 4번 입력 시
			// - 사용자로부터 삭제할 이름을 입력받습니다.
			// - phoneBook에 일치하는 이름이 있다면
			//		> phoneBook에서 해당 이름을 가진 전화번호 제거 후
			//		  "000의 전화번호를 삭제했습니다." 출력
			// - phoneBook에 일치하는 이름이 없다면
			//		> "000의 전화번호를 찾을 수 없습니다." 출력
			else if (menu == 4) {
				System.out.print("삭제할 이름: ");
				String name = sc.next();
					if (phoneBook.containsKey(name)) {
						phoneBook.remove(name);
						System.out.println(name + "의 전화번호를 삭제했습니다.");
					} else {
						System.out.println(name + "의 전화번호를 찾을 수 없습니다.");
					}
				
			}
			
			// 0번 입력 시
			// - "프로그램을 종료합니다." 출력 후 프로그램 종료
			else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				isTrue = false;
			}
			
			// 그 외
			// - "올바른 메뉴를 입력해주세요." 출력
			else {
				System.out.println("올바른 메뉴를 입력해주세요.");
			}
			
			
		}
	}

}
