package HOT100;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//示例:
//
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class L17电话号码的字母组合 {
	List<String> res ;
	public List<String> letterCombinations(String digits) {
		res = new ArrayList<>();
		if(digits.equals("")) return res;
		String[] dict = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		StringBuilder temp = new StringBuilder();
		backtrack(digits, dict, temp, 0);
		return res;
	}

	private void backtrack(String digits, String[] dict, StringBuilder temp, int x) {
		int len = digits.length();
		if (temp.length() == len) {
			res.add(temp.toString());
			return ;
		}
		
		int index = digits.charAt(x) - '0';
		String a = dict[index - 2];
		for (int i = 0; i < a.length(); i++) {
			temp.append(a.charAt(i));
			backtrack(digits, dict, temp, x+1);
			temp.deleteCharAt(temp.length()-1);
		}
	}
}
