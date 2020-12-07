package 字符串操作;

import java.util.HashMap;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
public class L14最长公共前缀 {
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
