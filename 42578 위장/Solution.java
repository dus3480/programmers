package clothes;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public int solution(String[][] clothes) {
		//map 으로 저장
        HashMap<String, Integer> clothesMap = new HashMap<>();
        ArrayList<String> keys =  new ArrayList<>();
        for (int i = 0; i < clothes.length; i++) {
			String[] cSet = clothes[i];
			if(clothesMap.containsKey(cSet[1])) {
				clothesMap.put(cSet[1], clothesMap.get(cSet[1]) + 1); 
			} else { 	
        		keys.add(cSet[1]);
        		clothesMap.put(cSet[1], 1);
        	}
		}
        
        int answer = 1;
        
        for (String key : keys) {
			answer *= (clothesMap.get(key) + 1);
		}
        answer--;
        return answer;
    }
}
