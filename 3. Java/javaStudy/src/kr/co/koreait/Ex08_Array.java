package kr.co.koreait;

import java.util.Arrays;
import java.util.Comparator;

public class Ex08_Array {

	public static void main(String[] args) {
		// 배열(Array)
		// - 같은 자료형을 가진 값들을 하나의 변수로 관리함
		
		// 요소(Element)
		// - 배열에 들어간 각각의 값들을 요소라고 표현
		
		// 인덱스(Index)
		// - 배열의 요소에 접근하기 위해 사용되는 번호 (요소의 위치를 의미함)
		// - 인덱스는 0부터 시작
		int[] arr = new int[4]; // 4만큼의 크기를 가진 배열 생성
		
		arr[0] = 10; // 0번 인덱스에 10을 넣겠다.
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		
		System.out.println("0번 인덱스 조회: "+ arr[0]); // 0번 인덱스의 요소를 조회하겠다.
		System.out.println("1번 인덱스 조회: "+ arr[1]);
		System.out.println("2번 인덱스 조회: "+ arr[2]);
		System.out.println("3번 인덱스 조회: "+ arr[3]); 
		
		for(int num : arr) {
			System.out.println(num);
		}
		
		
		int [] numbers = new int[10];
		
		// 배열의 요소에 랜덤 숫자 넣기
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = (int)(Math.random() * 30) + 1;
		}
		
		// 배열의 요소 1개씩 꺼내서 출력하기
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		// 배열의 요소 1개씩 꺼내서 짝수인것만 sum에 저장(합계)
		int sum = 0;
		for (int i=0; i<numbers.length;i++) {
			if (numbers[i] % 2 == 0) {
				sum += numbers[i];
			}  
		}
		System.out.println(sum);
		
		int[] nums = {3, 2, 6, 7, 1, 6, 8};
		
		System.out.println("첫 번째 요소: " + nums[0]);
		System.out.println("마지막 요소: " + nums[nums.length-1]);
		
		// nums 배열에서 가장 큰 값과 가장 작은 값 구하기
		// int min = nums[0];
		// int max = nums[0];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		 
		for(int i=0; i<nums.length;i++) {
			if (nums[i]>max) {
				max = nums[i];
			} 
			if (nums[i]<min) {
				min = nums[i];
			}
		}
		System.out.println("가장 작은 값: " + min);
		System.out.println("가장 큰 값: "+ max);
		
		// -----------------------------------------------------------
		// Arrays.toString()
		// - 반복문 없이 배열의 값들을 문자열 형태로 출력해주는 메서드
		int[] numbers2 = {4, 2, 3, 1, 7, 5};
		
		System.out.println(Arrays.toString(numbers2));
		
		// Arrays.sort()
		// - 배열에 있는 요소를 정렬해주는 메서드
		Arrays.sort(numbers2); // 오름차순 정렬
		
		System.out.println(Arrays.toString(numbers2));
		
		Integer[] numbers3 = {4, 2, 3, 1, 7, 5};
		Arrays.sort(numbers3, Comparator.reverseOrder());
		System.out.println(Arrays.toString(numbers3)); 
		
		// ----------------------------------------------------
		// 얕은 복사
		// - 배열의 주소 값만 가져와 참조하는 방식
		// - 하나의 배열 객체를 두 변수가 함께 공유함
		//		> 복사된 배열에서 수정하면 원본 배열도 영향을 받음
		int[] arrCopy1 = new int[3];
		int[] shallowCopy = arrCopy1;
		
		shallowCopy[1] = 999;
		System.out.println(Arrays.toString(arrCopy1));
		System.out.println(Arrays.toString(shallowCopy));
		
		// 깊은 복사
		// - 새로운 배열 객체를 생성하고 기존의 배열 데이터를 복사하는 방식
//		int[] arrCopy2 = {1, 2, 3};
//		int[] deepCopy = new int[arrCopy2.length];
		
//		deepCopy[0] = arrCopy2[0];
//		deepCopy[1] = arrCopy2[1];
//		deepCopy[2] = arrCopy2[2];
		
		// System.arraycopy(복사할 원본 배열, 복사를 시작할 위치, 저장할 배열, 저장을 시작할 위치, 복사할 요소의 수);
		// System.arraycopy(arrCopy2, 0, deepCopy, 0, arrCopy2.length); 
		
		int[] arrCopy2 = {1, 2, 3};
		int[] deepCopy = Arrays.copyOf(arrCopy2, arrCopy2.length);
		
		
		

	}

}
