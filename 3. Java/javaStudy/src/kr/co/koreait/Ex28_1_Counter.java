package kr.co.koreait;

public class Ex28_1_Counter {
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
}
