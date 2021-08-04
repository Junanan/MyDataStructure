package 回溯法;

import java.util.HashSet;
import java.util.Set;

public class 剑指Offer38字符串的排列 {
    Set<String> res;
    public String[] permutation(String s) {
        res = new HashSet<>();
        boolean[] isValid = new boolean[s.length()];
        StringBuilder stringbuilder = new StringBuilder();
        BackTracking(s, stringbuilder, isValid);
        return res.toArray(new String[res.size()]);
    }
    private void BackTracking(String s, StringBuilder stringbuilder, boolean[] isValid) {
        if (stringbuilder.length() == s.length()) {
            res.add(stringbuilder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isValid[i]) continue;
            isValid[i] = true;
            stringbuilder.append(s.charAt(i));
            BackTracking(s, stringbuilder, isValid);
            isValid[i] = false;
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        }
    }
}
