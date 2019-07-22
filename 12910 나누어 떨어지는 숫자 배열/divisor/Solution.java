package divisor;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int[] solution(int[] arr, int divisor) {
		int[] temp = arr.clone();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Arrays.sort(temp);
		
		for (int i : temp) {
			if(i%divisor == 0) {
				result.add(i);
			}
		}
		
		if(result.size() == 0) {
			return new int[] {-1};
		} else {
			int[] answer = new int [result.size()];
			int i = 0;
			for (int num : result) {
				answer[i] = num;
				i++;
			}
			return answer;
		}
	}
}
