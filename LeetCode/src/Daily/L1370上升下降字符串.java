package Daily;

public class L1370ÉÏÉıÏÂ½µ×Ö·û´® {
	public static void main(String[] args) {
		System.out.println(sortString("leetcode"));
	}
	public static String sortString(String s) {
		        int[] num = new int[26];
		        for (int i = 0; i < s.length(); i++) {
		            num[s.charAt(i) - 'a']++;
		        }

		        StringBuffer ret = new StringBuffer();
		        while (ret.length() < s.length()) {
		            for (int i = 0; i < 26; i++) {
		                if (num[i] > 0) {
		                    ret.append((char) (i + 'a'));
		                    num[i]--;
		                }
		            }
		            for (int i = 25; i >= 0; i--) {
		                if (num[i] > 0) {
		                    ret.append((char) (i + 'a'));
		                    num[i]--;
		                }
		            }
		        }
		        return ret.toString();
	}
}
