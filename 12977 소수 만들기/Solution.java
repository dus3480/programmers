package im;

public class Solution {
	public int solution(int[] nums) {
        int answer = 0;
        long length = nums.length; 
        int totalCount = (int) (length * (length - 1) * (length - 2) / 6);
        
        int [] total = new int[totalCount];
        int totalIndex = 0;
        for (int i = 0; i < nums.length; i++) { //1번자리 픽 
        	for (int j = i+1; j < nums.length; j++) {//2번자리 픽
				for (int k = j+1; k < nums.length; k++) {//3번자리 픽
					//System.out.println(String.format("(%d %d %d) ", nums[i],nums[j],nums[k]));
					total[totalIndex] = nums[i] + nums[j] + nums[k];
					totalIndex++;
				}
			}
		}
        
        for (int sum : total) {
        	boolean flag = true;
			for (int i = 2; i < sum; i++) {
				if(sum % i == 0) {
					//System.out.println(sum + " 이 수는 소인수가 아닙니다.");
					flag = false;
					break;
				}
			}
			if(flag) {
				answer++;
			}
		}

        return answer;
    }
}
