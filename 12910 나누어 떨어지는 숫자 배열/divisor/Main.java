package divisor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] test = new int [] {5, 9, 7, 10};
		int divisor = 5;
		Solution s = new Solution();
		int[] sol = s.solution(test, divisor);
		for (int i : sol) {
			System.out.print(" " + i);
		}
	}

}
