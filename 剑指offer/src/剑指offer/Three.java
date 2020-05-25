package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three {
//	请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//	示例 1：
//	输入：s = "We are happy."
//	输出："We%20are%20happy."
	public static String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for (Character c : s.toCharArray())// 字符串转成字符数组
		{
			if (c == ' ')
				res.append("%20");
			else
				res.append(c);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String s = "We are happy.";
		String a = "abcdefg";
		char[] b = a.toCharArray();
		System.out.println(b[0]);
		System.out.println(Arrays.toString(b));
		System.out.println(replaceSpace(s));
		// 第二种字符串转为字符,并不是数组，返回单个字符而已
		char c = s.charAt(0);
		System.out.println(c);
	}
}
