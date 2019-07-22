package bestAlbum;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = {500, 600, 150, 800, 2500};
		int[] result = sol.solution(genres, plays);
		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}

}
