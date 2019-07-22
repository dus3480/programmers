package im;

public class Solution {
	public int solution(int[] nums) {
        int answer = 0;
        long length = nums.length; 
        int totalCount = (int) (length * (length - 1) * (length - 2) / 6);
        
        int [] total = new int[totalCount];
        int totalIndex = 0;
        for (int i = 0; i < nums.length; i++) { //1���ڸ� �� 
        	for (int j = i+1; j < nums.length; j++) {//2���ڸ� ��
				for (int k = j+1; k < nums.length; k++) {//3���ڸ� ��
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
					//System.out.println(sum + " �� ���� ���μ��� �ƴմϴ�.");
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
