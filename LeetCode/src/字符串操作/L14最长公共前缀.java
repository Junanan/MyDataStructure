package �ַ�������;

import java.util.HashMap;

//��дһ�������������ַ��������е������ǰ׺��
//
//��������ڹ���ǰ׺�����ؿ��ַ��� ""��
//
//ʾ�� 1:
//
//����: ["flower","flow","flight"]
//���: "fl"
//ʾ�� 2:
//
//����: ["dog","racecar","car"]
//���: ""
//����: ���벻���ڹ���ǰ׺��
public class L14�����ǰ׺ {
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int len = strs.length;
		String a = strs[0];
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			int j = 0;
			for (String str : strs) {
				if (i < str.length() && str.charAt(i) == a.charAt(i))
					j++;
				else {
					return res.length() == 0 ? "" : res.toString();
				}
			}
			if (j == strs.length)
				res.append(a.charAt(i));
		}
		return res.length() == 0 ? "" : res.toString();
	}

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0)
				return "";
			String ans = strs[0];
			for (int i = 1; i < strs.length; i++) {
				int j = 0;
				for (; j < ans.length() && j < strs[i].length(); j++) {
					if (ans.charAt(j) != strs[i].charAt(j))
						break;
				}
				ans = ans.substring(0, j);
				if (ans.equals(""))
					return ans;
			}
			return ans;
		}
	}
}
