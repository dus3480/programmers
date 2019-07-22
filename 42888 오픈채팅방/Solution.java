package openChat20190101;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	enum recordType { Enter,Leave,Change,ERROR }
	
	public String[] solution(String[] record) {
		
		HashMap<String, String> usersMap = new HashMap<>();
		ArrayList<String> midResult = new ArrayList<>();
		
		String[] answer; // 뒤에서 초기화 해주자
		
		for(int i = 0 ; i < record.length ; i++) {
			//회원별 저장
			String msg = record[i];
			String[] sub = msg.split(" ");
			recordType type;
			
			if(sub.length >= 2) {
				String key = "";
				type = recordType.valueOf(sub[0]);
				key = sub[1];
				if(type != recordType.Leave && type != recordType.ERROR) {
					if(sub.length > 2) {
						String name = sub[2];
						usersMap.put(key, name);
					}
				}
				if(type != recordType.Change) {
					midResult.add(key + ";" + type.toString());
				}
			} else {
				System.out.println("ERROR msg parse");			
				return new String[] {};
			}
		}
		
		
		answer = new String[midResult.size()];
		
		for (int i = 0; i < midResult.size(); i++) {
			String mid = midResult.get(i);
			String[] sub = mid.split(";");
			String name = usersMap.get(sub[0]) != null ? usersMap.get(sub[0]) : "";
			recordType type = recordType.valueOf(sub[1]) != null ? recordType.valueOf(sub[1]): recordType.ERROR;
			
			answer[i] = name + "님이";
			
			switch (type) {
			case Enter:
				answer[i] += " 들어왔습니다.";
				break;
			case Leave:
				answer[i] += " 나갔습니다.";
				break;
			case Change:case ERROR:default:
				answer[i] += "";
				break;
			}
		}
		return answer;
	}
}
