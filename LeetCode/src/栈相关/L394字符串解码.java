package 栈相关;

import java.util.Stack;

public class L394字符串解码 {
    public String decodeString(String s) {
        Stack<String> stack_string = new Stack<>();
        Stack<Integer> stack_num = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] charArr = s.toCharArray();
        int num = 0;
        for (char c : charArr) {
            if (c == '[') {
                stack_num.add(num);
                stack_string.add(res.toString());
                res = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int temp = stack_num.pop();
                StringBuilder tempString = new StringBuilder();
                while (temp > 0) {
                    tempString.append(res);
                    temp--;
                }
                res = new StringBuilder(stack_string.pop() + tempString);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt("" + c);//*10 是因为可能有两位的数字
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
