package iron;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        int num = n;
        
        while(num > 2) {
        	int[] temp = divide(num);
            if(temp[1] > 0) {
            	ans++;
            }
            num = temp[0];
        }
        return ans;
    }
    private int [] divide(int n) {
    	int [] result = new int[2];
    	result[0] = n/2;
    	result[1] = n%2;
    	return result;
    }
}