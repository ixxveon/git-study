package kr.co.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex27_1_Product {
	Scanner sc = new Scanner(System.in);
//	- 참고 : 상품 리스트는 매개변수로 받아서 활용 하셔도 되고, 필드에 넣어 사용하셔도 됩니다.
//	- addProduct()
//		> 매개변수로 상품 리스트를 전달받습니다.
//		> 사용자로부터 상품명을 입력 받습니다.
//		> 상품 리스트에 존재하는 상품명일 경우 DuplicateProductException("중복 상품입니다.") 예외를 발생시키세요.
//		> 사용자로부터 가격을 입력 받습니다.
//		> 입력받은 가격이 0 미만일 경우 InvalidPriceException("가격은 음수로 될 수 없습니다.") 예외를 발생시키세요.
//		> 사용자로부터 초기 재고를 입력 받습니다.
//		> 초기 재고가 0 미만일 경우 InvalidStockException("재고는 마이너스가 될 수 없습니다.") 예외를 발생시키세요.
//		> 상품 리스트에 ProductInfo 객체를 추가하여 상품을 등록하세요.
//		> "상품명: OOO, 가격: OOO, 재고: OOO이 정상적으로 등록되었습니다."를 출력하세요.
	public void addProduct(ArrayList<Ex27_1_ProductInfo> list) {
		System.out.println("상품명: ");
		String name = sc.nextLine();
		
		for(Ex27_1_ProductInfo p : list) {
			if(p.getName().equals(name)) {
				throw new Ex27_1_DuplicateProductException("중복 상품입니다.");
			} 
		}
		
		System.out.println("상품가격: ");
		int price = sc.nextInt();
		sc.nextLine();
		
		if(price < 0) {
			throw new Ex27_1_InvalidPriceException("가격은 음수로 될 수 없습니다.");
		}
		System.out.println("상품재고: ");
		int stock = sc.nextInt();
		sc.nextLine();
		
		if(stock < 0) {
			throw new Ex27_1_InvalidStockException("재고는 마이너스가 될 수 없습니다.");
		}
		
		list.add(new Ex27_1_ProductInfo(name, price, stock));
		System.out.println("상품명: " + name + ", 가격: " + price + ", 재고: " + stock + "이 정상적으로 등록되었습니다.");
		
		
		
	}
	
//	- removeProduct()
//		> 매개변수로 상품 리스트를 전달받습니다.
//		> 사용자로부터 제거할 상품명을 입력 받습니다.
//		> 상품 리스트에 제거할 상품이 존재하지 않을 경우 ProductNotFoundException("존재하지 않는 상품입니다.") 예외를 발생시키세요.		
//		> 해당하는 상품을 리스트에서 삭제하세요.
//		> "상품명:OOO이 정상적으로 삭제되었습니다." 출력
	public void removeProduct(ArrayList<Ex27_1_ProductInfo> list) {
		System.out.println("제거할 상품명: ");
		String name = sc.nextLine();
		boolean found = false;
		
		Iterator<Ex27_1_ProductInfo> it = list.iterator();
		while(it.hasNext()) {
			Ex27_1_ProductInfo p = it.next();
			if(p.getName().equals(name)) {
				it.remove();
				found = true;
				System.out.println("상품명: " + name + "이 정상적으로 삭제되었습니다.");
				break;
			}
		}
		if(!found) {
			throw new Ex27_1_ProductNotFoundException("존재하지 않는 상품입니다.");
		}
	}
	
//	- showAll()
//		> 매개변수로 상품 리스트를 전달 받습니다.
//		> 모든 상품을 출력하세요.
//		> 출력 예시) "상품명: OOO, 가격: OOO, 재고: OOO"
//		> 참고) ProductInfo에서 toString을 오버라이딩하여 활용하면 더욱 편하게 출력할 수 있습니다.
//	- searchProduct()
//		> 매개변수로 상품 리스트를 전달 받습니다.
//		> 사용자로부터 찾을 상품명을 입력 받으세요.
//		> 상품 리스트에서 조회할 상품이 존재하지 않을 경우 ProductNotFoundException("존재하지 않는 상품입니다.") 예외를 발생시키세요.		
//		> 해당하는 상품을 출력하세요.
//		> 출력 예시) "상품명: OOO, 가격: OOO, 재고: OOO"
//		> 참고) ProductInfo에서 toString을 오버라이딩하여 활용하면 더욱 편하게 출력할 수 있습니다.
//	- removeStock()
//		> 매개변수로 상품 리스트를 전달 받습니다.
//		> 사용자로부터 출고 처리할 상품명을 입력 받으세요.
//		> 상품 리스트에서 해당 상품이 존재하지 않을 경우 ProductNotFoundException("존재하지 않는 상품입니다.") 예외를 발생시키세요.		
//		> 사용자로부터 출고할 수량(재고)을 입력 받으세요.
//		> 출고할 수량(재고)가 0 미만일 경우 InvalidStockException("재고는 마이너스가 될 수 없습니다.") 예외를 발생시키세요.
//		> 현재 재고보다 많은 수량을 출고한다면  OutOfStockException("재고가 부족합니다.") 예외를 발생시키세요.
//		> setter를 활용하여 사용자가 입력한 출고할 수량(재고)만큼을 현재 상품의 재고에서 빼세요.
//			>> ex) 현재 상품의 재고(stock): 10  ,  출고할 수량 : 3일 경우  출고 후의 상품 재고는 7이 되어야 함
//		> "OOO 상품이 OO개 출고되어 OO의 재고가 남았습니다." 출력
//	- updatePrice()
//		> 매개변수로 상품 리스트를 전달 받습니다.
//		> 가격을 수정할 상품 이름을 입력 받으세요.
//		> 상품 리스트에서 해당 상품이 존재하지 않을 경우 ProductNotFoundException("존재하지 않는 상품입니다.") 예외를 발생시키세요.	
//		> 사용자로부터 변경할 가격을 입력 받으세요.
//		> 입력받은 가격이 0 미만일 경우 InvalidPriceException("가격은 음수로 될 수 없습니다.") 예외를 발생시키세요.
//		> setter를 활용하여 해당 상품의 가격을 변경하세요.
//		> "OOO 상품의 가격이 OOO으로 변경되었습니다." 출력
//	- totalAsset()
//		> 매개변수로 상품 리스트를 전달 받습니다.
//		> 총 자산을 구하세요.
//			>> 총 자산 : 모든 물품의 가격*재고의 합
//		> "총 자산 : OOO원" 출력


}
