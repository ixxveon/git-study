package kr.co.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex26_1_Book {
	Scanner sc = new Scanner(System.in);

	// add 메서드
	// - 추가할 도서 이름을 입력받습니다. (문자열)
	//	> 도서 리스트에 이미 존재하는 도서라면 Ex26_1_DuplicateBookException 발생
	// - 추가할 도서의 저자를 입력받습니다. (문자열)
	// - 리스트에 Ex26_2_bookInfo 객체를 추가하세요.
	public void add(ArrayList<Ex26_1_BookInfo> list) {
		System.out.print("추가할 도서 이름: ");
		String title = sc.next();
		
		for(Ex26_1_BookInfo s : list) {
			if(s.getTitle().equals(title)) {
				throw new Ex26_1_DuplicateBookException("이미 존재합니다!");
			}
		}
		
		System.out.print("추가할 저자 이름: ");
		String author = sc.next();
		System.out.println();
		
		list.add(new Ex26_1_BookInfo(title, author));
		
		
		
	}
	
	// remove 메서드
	// - 삭제할 도서 이름을 입력 받습니다. (문자열)
	//	> 도서 리스트에 존재하지 않는 도서라면 Ex26_1_BookNotFoundException 발생
	// - 리스트에 해당하는 도서 객체를 제거하세요.
	public void remove(ArrayList<Ex26_1_BookInfo> list) {
		System.out.print("삭제할 도서 이름: ");
		String title = sc.next();
		
		// Iterator: 컬렉션을 하나씩 꺼내보는 전용 도구
		// list 안을 순서대로 탐색할 도구를 만듦
		// 아직 아무것도 안 꺼낸 상태
		Iterator<Ex26_1_BookInfo> it = list.iterator();
		
		boolean found = false;
		
		// 다음 책이 남아있으면 계속 반복
		while (it.hasNext()) {
			// 다음 책 탐색 (s는 책 1권)
			Ex26_1_BookInfo s = it.next();
			if (s.getTitle().equals(title)) {
				it.remove();
				found = true;
				break; // 하나 삭제
			}
		}
		// found == false
		if (!found) {
			throw new Ex26_1_BookNotFoundException("존재하지 않는 도서입니다!");
		}
		
	}
	
	// show 메서드
	// - 전체 도서를 출력합니다. (도서 이름, 저자)
	public void show(ArrayList<Ex26_1_BookInfo> list) {
		for(Ex26_1_BookInfo s : list) {
			System.out.println(s.toString());
		}
	}
	
	// search 메서드
	// - 검색할 도서 이름을 입력 받습니다. (문자열)
	//	> 도서 리스트에 존재하지 않는 도서라면 Ex26_1_BookNotFoundException 발생
	// - 리스트에 해당하는 도서가 있다면 정보를 출력하세요. (도서 이름, 저자)
	public void search(ArrayList<Ex26_1_BookInfo> list) {
		System.out.print("검색할 도서 이름: ");
		String title = sc.next();
		
		boolean found = false;
		
		Iterator<Ex26_1_BookInfo> it = list.iterator();
		while(it.hasNext()) {
			Ex26_1_BookInfo s = it.next();
			if(s.getTitle().equals(title)) {
				System.out.println(s.toString());
				found = true;
			}
		}
		if(!found) {
			throw new Ex26_1_BookNotFoundException("존재하지 않는 도서입니다!");
		}
		
		
	}
	
}
