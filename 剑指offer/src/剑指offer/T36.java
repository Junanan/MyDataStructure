package ��ָoffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//����һ���ַ�������ӡ�����ַ������ַ����������С�
//�����������˳�򷵻�����ַ������飬�����治�����ظ�Ԫ�ء�
//ʾ��:
//���룺s = "abc"
//�����["abc","acb","bac","bca","cab","cba"]
public class T36 {
	static List<String> res = new LinkedList<>();
	static char[] c;
	public static String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		String[] a = new String[res.size()];
		return res.toArray(a);
	}
	 static void dfs(int x) {
		if (x == c.length - 1) {
			res.add(String.valueOf(c)); // ������з���
			return;	
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {
			if (set.contains(c[i])) continue; // �ظ�����˼�֦  ���� s=aab
			set.add(c[i]);
			swap(i, x); // �������̶���λΪ c[i]
			dfs(x + 1); // �����̶��� x + 1 λ�ַ�
			swap(i, x); // �ָ����� ���� acb ������abc�Ļ�  �����cab ����
		}
	}

	 static void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
	 public static void main(String[] args) {
		String s = "abcd";
		System.out.println(Arrays.toString(permutation(s)));
	}
}
