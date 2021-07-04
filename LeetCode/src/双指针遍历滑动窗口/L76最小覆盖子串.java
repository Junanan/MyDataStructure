package 双指针遍历滑动窗口;

import java.util.HashMap;

public class L76最小覆盖子串 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //收缩左边界
            while (valid == need.size()) {
                char c2 = s.charAt(left);
                if (right - left < len) {
                    len = right - left + 1;
                    start = left;
                }
                if (need.containsKey(c2)) {
                    if (window.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
                left++;
            }
            right ++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }
}
