package ��ָoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three {
//	��ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
//	ʾ�� 1��
//	���룺s = "We are happy."
//	�����"We%20are%20happy."
	public static String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for (Character c : s.toCharArray())// �ַ���ת���ַ�����
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
		// �ڶ����ַ���תΪ�ַ�,���������飬���ص����ַ�����
		char c = s.charAt(0);
		System.out.println(c);
	}
}
