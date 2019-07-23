package fail;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int [] result0 = sol.solution(4, new int [] {4,4,4,4,4});
		
		System.out.println("============================================");
		for (int i : result0) {
			System.out.print(i + " ");
		}
		System.out.println();
//		int [] result1 = sol.solution(5, new int [] {2, 1, 2, 6, 2, 4, 3, 3});
//		System.out.println("============================================");
//		for (int i : result1) {
//			System.out.print(i + " ");
//		}
	}

}
