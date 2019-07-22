package openChat20190101;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] test = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = sol.solution(test);
		
		for(String msg:result) {
			System.out.println(msg);
		}
	}

}
