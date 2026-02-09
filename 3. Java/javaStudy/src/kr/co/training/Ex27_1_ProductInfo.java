package kr.co.training;

public class Ex27_1_ProductInfo {
//	- 문자열 상품명(name), 정수형 가격(price)과 재고(stock) 필드를 가집니다.
//		> 접근제어자 : private
	private String name;
	private int price;
	private int stock;
	
//	- 매개변수 3개를 가지는 생성자를 작성하고 필드에 값을 할당하세요.
	Ex27_1_ProductInfo(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

//	- 각각의 필드들을 getter와 setter를 가집니다.
//		> 문제 풀이하면서 setter의 로직을 살짝 수정할 일이 있으니, 나중에 필요하면 setter의 동작을 조금 수정하셔도 됩니다.
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}

	
	
	



}
