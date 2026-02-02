package kr.co.training;

public class Ex20_2_Book {

	// 책 빌리는 메서드 (borrowBook)
	// - 매개변수1은 자료형: Ex20_2_BookInfo
	// - 매개변수2는 자료형: int
	//		> 빌릴 책의 수
	// - Ex20_2_BookInfo의 bookCount 값을 빌릴 책의 수만큼 뺍니다.
	// - "책을 0권 빌렸습니다." 출력
	public void borrowBook(Ex20_2_BookInfo bookInfo, int borrowCount) {
		int currentBook = bookInfo.getBookCount(); // 현재 책의 수
		
		bookInfo.setBookCount(currentBook - borrowCount);
		
		System.out.printf("책을 %d권 빌렸습니다. \n", borrowCount);
	}
	
	// 책을 반납하는 메서드 (returnBook)
	// - 매개변수 1은 자료형: Ex20_2_BookInfo
	// - 매개변수 2는 자료형: int
	//		> 반납할 책의 수
	// - Ex20_2_BookInfo의 bookCount 값을 반납할 책의 수만큼 더합니다.
	// - "책을 0권 반납했습니다." 출력
	public void returnBook(Ex20_2_BookInfo bookInfo, int returnCount) {
		int currentBook = bookInfo.getBookCount();
		
		bookInfo.setBookCount(currentBook + returnCount);
		
		System.out.printf("책을 %d권 반납했습니다. \n", returnCount);
	}
	
	// 현재 도서관에 남은 책의 수를 출력하는 메서드 (showBookCount)
	// - 매개변수 1은 자료형: Ex20_2_BookInfo
	// - 현재 남은 책의 수는 Ex20_2_BookInfo의 bookCount 입니다.
	// - "현재 도서관에는 0권의 책이 있습니다." 출력
	public void showBookCount(Ex20_2_BookInfo bookInfo) {
		System.out.printf("현재 도서관에는 %d권의 책이 있습니다. \n", bookInfo.getBookCount());
	}
}
