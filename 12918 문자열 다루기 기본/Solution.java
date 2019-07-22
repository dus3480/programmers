package isInteger;

class Solution {
	public boolean solution(String s) {//isInteger
		//±Ê¿Ã = 4 or 6 
		if(s.length() == 4 || s.length() == 6) {
			try {
				int result = Integer.valueOf(s);
				return true;
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				return false;
				// TODO: handle exception
			}
		} else {
			return false;
		}
		
	}
}