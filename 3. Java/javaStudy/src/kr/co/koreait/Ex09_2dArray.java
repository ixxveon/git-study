package kr.co.koreait;

public class Ex09_2dArray {

	public static void main(String[] args) {
		// 2차원 배열
		// - 배열에 배열이 있는 구조
		int[][] arr = new int[2][3];
		
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 100;
		arr[1][1] = 200;
		arr[1][2] = 300;
		
		int[][] arr2 = {
				{10, 20, 30},
				{100, 200, 300}
		};
		
		// 인벤토리라는 2차원 배열
		// - 각각의 데이터가 {10, 5, 8}, {3, 7, 2}, {6, 1, 9}
		// - {물품번호, 위치, 재고}
		// - 물품번호 10번은 마우스, 3번은 키보드, 6번은 모니터
		int[][] inventory = {
				{10, 5, 8}, 
				{3, 7, 2}, 
				{6, 1, 9}
		};
		for(int i=0; i<inventory.length;i++) {
			for(int j=0; j<inventory[i].length; j++) {
				System.out.println(inventory[i][j]);
			}
		}
		
		for(int[] a : inventory) {
			for(int b : a) {
				
			}
		}
		
		
	}

}
