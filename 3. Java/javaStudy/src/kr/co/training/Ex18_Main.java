package kr.co.training;

import java.util.Scanner;

public class Ex18_Main {

	public static void main(String[] args) {
		Ex18_1_Buy buy = new Ex18_1_Buy(600000);
//		Scanner sc = new Scanner(System.in);
//		System.out.print("소지금을 입력하세요.");
		
		buy.buyMonitor();
		buy.buyMouse();
		buy.buyDesktop(); 
		
	} 

}
