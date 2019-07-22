package bestAlbum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	
	public int[] solution(String[] genres, int[] plays) {
		ArrayList<String> keys = new ArrayList<>();
		
		//index와 조회수 연결
		ArrayList<int[]> indexAndPv = new ArrayList<>();
		for (int i = 0; i < plays.length; i++) {
			int[] pare = {i,plays[i]};
			indexAndPv.add(pare);
		}
		
		//장르 - 인덱스 - 플레이수 맵
		HashMap<String, ArrayList<int[]>> genreIndexAndPvMap = new HashMap<>();
		//<genre:[index,play]> 형태
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
		
		//장르별 총 플레이수 집계
		HashMap<String, Integer> genrePvMap = new HashMap<>();
		for (String key : keys) {
			ArrayList<int[]> subPlays = genreIndexAndPvMap.get(key);
			int oneSum = 0;
			for (int[] sp : subPlays) {
				oneSum += sp[1];
			}
			genrePvMap.put(key, oneSum);
		}

		//장르이름 배열을 장르별 총 플레이수로 정렬
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
		
		//곡 좀 뽑자 이제... 라인이 너무 길어졌다
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
