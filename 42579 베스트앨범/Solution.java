package bestAlbum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	
	public int[] solution(String[] genres, int[] plays) {
		ArrayList<String> keys = new ArrayList<>();
		
		//index�� ��ȸ�� ����
		ArrayList<int[]> indexAndPv = new ArrayList<>();
		for (int i = 0; i < plays.length; i++) {
			int[] pare = {i,plays[i]};
			indexAndPv.add(pare);
		}
		
		//�帣 - �ε��� - �÷��̼� ��
		HashMap<String, ArrayList<int[]>> genreIndexAndPvMap = new HashMap<>();
		//<genre:[index,play]> ����
		int playsIndex = 0;
		for (String genre : genres) {
			if(genreIndexAndPvMap.containsKey(genre)) {
				ArrayList<int[]> tempArray = genreIndexAndPvMap.get(genre);
				tempArray.add(indexAndPv.get(playsIndex));
				genreIndexAndPvMap.put(genre, tempArray);
			} else {
				ArrayList<int[]> tempArray = new ArrayList<>();
				tempArray.add(indexAndPv.get(playsIndex));
				genreIndexAndPvMap.put(genre,tempArray);
				keys.add(genre);
			}
			playsIndex++;
		}
		
		//�帣�� �� �÷��̼� ����
		HashMap<String, Integer> genrePvMap = new HashMap<>();
		for (String key : keys) {
			ArrayList<int[]> subPlays = genreIndexAndPvMap.get(key);
			int oneSum = 0;
			for (int[] sp : subPlays) {
				oneSum += sp[1];
			}
			genrePvMap.put(key, oneSum);
		}

		//�帣�̸� �迭�� �帣�� �� �÷��̼��� ����
		String [] sortGenreName = new String[keys.size()];
		for (int i = 0; i < sortGenreName.length; i++) {
			sortGenreName[i] = keys.get(i);
		}
		for (int i = 0; i < sortGenreName.length; i++) {
			for (int j = 0; j < sortGenreName.length - i - 1; j++) {
				if(genrePvMap.get(sortGenreName[j]) < genrePvMap.get(sortGenreName[j+1])) {
					String temp = sortGenreName[j+1];
					sortGenreName[j+1] = sortGenreName[j];
					sortGenreName[j] = temp;
				}
			}
		}
		
		//�� �� ���� ����... ������ �ʹ� �������
		ArrayList<Integer> resultList = new ArrayList<>();
		for (String name : sortGenreName) {
			ArrayList<int[]> subPlays = genreIndexAndPvMap.get(name);
			for(int i = 0; i < subPlays.size(); i++) {
				for (int j = 0; j < subPlays.size() - i - 1; j++) {
					if(subPlays.get(j)[1] < subPlays.get(j+1)[1]) {
						int [] temp = subPlays.remove(j+1);
						subPlays.add(j,temp);
					}
				}
			}
			
			for (int i = 0; i < 2; i++) {
				if( i < subPlays.size()) {
					resultList.add(subPlays.get(i)[0]);
				}
			}
		}
		
		int[] answer = {};
		answer = new int[resultList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = resultList.get(i);
		}
		return answer;
	}
}
