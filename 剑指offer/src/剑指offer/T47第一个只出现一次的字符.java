package ��ָoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//���ַ��� s ���ҳ���һ��ֻ����һ�ε��ַ������û�У�����һ�����ո�
//
//ʾ��:
//
//s = "abaccdeff"
//���� "b"
//
//s = "" 
//���� " "
public class T47��һ��ֻ����һ�ε��ַ� {
	public static char firstUniqCharr(String s) {
		char[] a = s.toCharArray();
		HashMap<Character, Boolean> map = new HashMap<>();
		for (char i : a) {
			map.put(i, !map.containsKey(i));
		}
		for (char i : a) {
			if (map.get(i))
				return i;
		}
		return ' ';
	}

	public static char firstUniqCharrr(String s) {
		char[] a = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char i : a) {
			Integer count = map.get(i);
			count = count == null ? 1 : ++count;
			map.put(i, count);
		}
		for (char b : a) {
			if (map.get(b) == 1)
				return b;
		}
		return ' ';
	}

	public static char firstUniqChar(String s) {
		char[] a = s.toCharArray();
		char b;
		List<Character> lin = new ArrayList<>();
		List<Character> lin2 = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (lin.contains(a[i]))
				lin2.add(a[i]);
			lin.add(a[i]);
		}
		if (!lin2.isEmpty()) {
			lin.removeAll(lin2);
			b = lin.get(0);
		} else
			b = ' ';
		return b;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqCharrr("abaccdeff"));
	}

}
