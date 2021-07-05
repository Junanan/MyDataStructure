package 双指针遍历滑动窗口;

import java.util.HashMap;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//
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
public class L3无重复字符的最长子串 {
    //	public int lengthOfLongestSubstring(String s) {
//		if(s.length()==0) return 0;
//		HashMap<Character, Integer> map = new HashMap<>();
//		char[] temp = s.toCharArray();
//		int len = temp.length;
//		int left = 0;
//		int res = 0;
//		for (int i = 0; i < len; i++) {
//			if(map.containsKey(temp[i])) {
//				left = Math.max(left, map.get(temp[i])+1);//   max的作用防止指针左移（栗子abba 当j指向最后一个a时如果是 i = map.get() i 就等于0了）
//			}
//			map.put(temp[i],i);
//			res = Math.max(res, i-left+1);  // ＋1 因为left=0 例子：'' '' 输出为1 如果没有＋1则为0
//		}
//		return res;
//	}
    //维护一个窗口（队列）当有重复的元素从左边移除
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                char c2 = s.charAt(left);
                map.put(c2, map.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

}
