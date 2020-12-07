package 栈相关;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//示例 1:
//
//输入: "()"
//输出: true
//示例 2:
//
//输入: "()[]{}"
//输出: true
//示例 3:
//
//输入: "(]"
//输出: false
//示例 4:
//
//输入: "([)]"
//输出: false
//示例 5:
//
//输入: "{[]}"
//输出: true
public class L20有效的括号 {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		for(int i =0;i<s.length();i++) {
			if(!stack.isEmpty()&&(stack.peek()==map.get(s.charAt(i)))) {
				stack.pop();
				continue;
			}
		stack.push(s.charAt(i));
		}
		return stack.isEmpty();
    }
	public static void main(String[] args) {
		String a = "()[{}";
		System.out.println(isValid(a));
	}
}
