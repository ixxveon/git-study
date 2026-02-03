package kr.co.training;

public class Training01_Calc {

	public int sum(int[] numbers) {
		int result1 = 0;
		for(int i=0; i<numbers.length; i++) {
			result1 += numbers[i];
		}
		return result1;
	}
	
	public int max(int[] numbers) {
		int max = numbers[0];
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]>max) {
				max = numbers[i];
			}
		}
		return max;
		}

	public int min(int[] numbers) {
		int min = numbers[0];
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]<min) {
				min = numbers[i];
			}
		}
		return min;
	}
}
