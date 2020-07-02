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
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) return 0;
		Map<Character, Integer> dic = new HashMap<>();
		int i = 0, res = 0;
		for (int j = 0; j < s.length(); j++) {
			if (dic.containsKey(s.charAt(j)))
				i = Math.max(i, dic.get(s.charAt(j))+1); // 更新左指针 i   max的作用防止指针左移（栗子abba 当j指向最后一个a时如果是 i = dic.get() i 就等于0了） 
			dic.put(s.charAt(j), j); // 哈希表记录
			res = Math.max(res, j - i+1); // 更新结果
		}
		return res;
	}
//	复杂度分析：
//	时间复杂度 O(N) ： 其中 N 为字符串长度，动态规划需遍历计算 dp 列表。
//	空间复杂度 O(1)： 字符的 ASCII 码范围为 0 ~ 127 ，哈希表 dic 最多使用 O(128) = O(1大小的额外空间。

	public static int lengthOfLongestSubstringg(String s) {
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
//		System.out.println(lengthOfLongestSubstring(s));
	}

}
