package phonebook;

class Solution {
	public boolean solution(String[] phone_book) {
		//포함되 있으면 false 포함안되어있으면 true
		//phoneNumber.length = 1 ~ 20
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = i+1; j < phone_book.length; j++) {
				//짧은 문자열을 앞에 두고 긴 문자열을 짧은 문자열 크기만큼 파싱해서 값 비교
				if(phone_book[i].length() < phone_book[j].length()) {
					if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
						return false;
					}
				} else {
					if(phone_book[j].equals(phone_book[i].substring(0, phone_book[j].length()))) {
						return false;
					}
				}
			}
		}
		return true;
	}
}