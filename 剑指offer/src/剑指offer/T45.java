package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//示例 1:
//输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
public class T45 {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		char[] a = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 0;
		int count = 0;
		for (int j = 0; j < a.length; j++) {
			int i = map.containsKey(a[j]) ? map.get(a[j]) : -1;
			map.put(a[j], j);
			count = count < j - i ? count + 1 : j - i;
			res = Math.max(res, count);
		}
		return res;
	}
	public static void main(String[] args) {
		String s = new String("abcabcbb");
		System.out.println(lengthOfLongestSubstring(s));
	}

}
