package maraton;

import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> resultMap = new HashMap<>();
		for (String name : participant) {
			if(resultMap.containsKey(name)) {
				resultMap.put(name, resultMap.get(name) + 1);
			} else {
				resultMap.put(name, 1);
			}
		}
		
		for (String name : completion) {
			resultMap.put(name, resultMap.get(name) - 1);
		}
		
		for (String name : participant) {
			if(resultMap.get(name) > 0 )
				return name;
		}
		
		return "";
	}
}