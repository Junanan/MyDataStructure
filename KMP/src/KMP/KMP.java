package KMP;



// PMT数组为 前后缀相同字符数 为方便 将其向右偏移一位得到next数组第一位为-1；
public class KMP {
	public static int kmp(String str, String patten) {
		int i = 0;
		int j = 0;
		int[] next = getnext(patten);
		while (i < str.length() && j < patten.length()) {
			if (j == -1 || str.charAt(i) == patten.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j]; // 相当于str串向右移动了 已匹配x - next[j]
			}
		}

		// 匹配成功，返回模式串str在文本str中的位置，否则返回-1
		if (j == patten.length()) {
			return i - j;
		} else
			return -1;
	}
	//其实，求next数组的过程完全可以看成字符串匹配的过程，即以模式字符串为主字符串，以模式字符串的前缀为目标字符串，
	// 一旦字符串匹配成功，那么当前的next值就是匹配成功的字符串的长度。
	private static int[] getnext(String str) {
		int[] next = new int[str.length() + 1];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < str.length()) {
			if (j == -1 || str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;
	}

	public static void main(String[] args) {
		System.out.println(kmp("abcdeas","as"));
		getnext("abababca");
	}
}
