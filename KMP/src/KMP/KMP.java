package KMP;

import java.util.LinkedList;
import java.util.Queue;

// PMT����Ϊ ǰ��׺��ͬ�ַ��� Ϊ���� ��������ƫ��һλ�õ�next�����һλΪ-1��
public class KMP {
	public static int kmp(String str, String sub) {
		int i = 0;
		int j = 0;
		int[] next = getnext(sub);
		while (i < str.length() && j < sub.length()) {
			if (j == -1 || str.charAt(i) == sub.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j]; // �൱��sub�������ƶ��� ��ƥ��x - next[j]
			}
		}

		// ƥ��ɹ�������ģʽ��sub���ı�str�е�λ�ã����򷵻�-1
		if (j == sub.length()) {
			return i - j;
		} else
			return -1;
	}

	private static int[] getnext(String sub) {
		int[] next = new int[sub.length() + 1];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < sub.length()) {
			if (j == -1 || sub.charAt(i) == sub.charAt(j)) {
				++i;
				++j;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;
	}

	public static void main(String[] args) {
		System.out.println(kmp("abcdeas","as"));
	}
}
