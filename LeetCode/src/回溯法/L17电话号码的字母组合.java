package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class L17电话号码的字母组合 {
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
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
