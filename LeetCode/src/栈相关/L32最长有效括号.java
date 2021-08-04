package 栈相关;

import java.util.Stack;
//和每日温度类似
public class L32最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                }
                res = Math.max(res,i - stack.peek());
            }
        }
        return res;
    }
}
