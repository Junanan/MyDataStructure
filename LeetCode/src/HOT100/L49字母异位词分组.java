package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//示例:
//
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
public class L49字母异位词分组 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for(int i=0;i<strs.length;i++) {
			char[] s = strs[i].toCharArray();
			Arrays.sort(s);
			String value =String.valueOf(s);
			if(map.containsKey(value)) {
				map.get(value).add(strs[i]);
			}else {
				List<String> temp = new ArrayList<>();
				temp.add(strs[i]);
				map.put(value,temp);
			}
			
		}
		for(List<String> a : map.values() ) {
			res.add(a);
		}
		return res;
	
    }
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
		String[] s =new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
//		int[] b =new int[] {1,23,4};
		char[] a =s[0].toCharArray();
		System.out.println(Arrays.toString(a));
//		System.out.println(String.valueOf(a));
	}
}
