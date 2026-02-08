package kr.co.training;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex27_ProductMain {


    public static void main(String[] args) {

    	ArrayList<Ex27_1_ProductInfo> list = new ArrayList<>();// 상품 리스트
    	Ex27_1_Product product = new Ex27_1_Product();
    	Scanner sc = new Scanner(System.in);
    	
        while (true) {

            System.out.println("""
            ===== 상품 관리 프로그램 =====
            1. 상품 등록
            2. 상품 삭제
            3. 전체 조회
            4. 상품 검색
            5. 재고 입고
            6. 재고 출고
            7. 가격 수정
            8. 전체 자산 조회
            0. 종료
            ============================
            """);

            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            
            switch(menu) {
            case 1 -> product.addProduct(list);
            case 2 -> product.removeProduct(list);
            }
            if (menu == 0) {
            	System.out.println("프로그램을 종료합니다.");
            	break;
            }
        }
    }
}
