package ջ���;

import java.util.Stack;
//��ÿ���¶�����
public class L32���Ч���� {
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
