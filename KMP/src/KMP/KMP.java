package KMP;

import java.util.LinkedList;
import java.util.Queue;

// PMT数组为 前后缀相同字符数 为方便 将其向右偏移一位得到next数组第一位为-1；
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
				j = next[j]; // 相当于sub串向右移动了 已匹配x - next[j]
			}
		}

		// 匹配成功，返回模式串sub在文本str中的位置，否则返回-1
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
