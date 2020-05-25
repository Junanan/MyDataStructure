package 剑指offer;

import java.util.Arrays;
///////输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//示例 1:
//输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]

///// 面试官陷阱   如果用int 或者 longlong 当N很大的时候会不会溢出？
public class T16 {
	///// 这题返回int【】 也不会大到哪去
	public static int[] printNumbers(int n) {
		int t = (int) Math.pow(10, n);
		int[] a = new int[t - 1];
		int k = 0;
		for (int i = 1; i < t; i++) {
			a[k++] = i;
		}
		return a;
	}

	///// 递归全排列
	// 递归排列所有数列的可能
	public void print1ToMaxNDigits_3(int n) {
		if (n <= 0)
			return;

		StringBuffer str = new StringBuffer(n);
		for (int i = 0; i < n; i++) {
			str.append('0');
		}

		for (int i = 0; i < 10; i++) {
			str.setCharAt(0, (char) (i + '0'));
			print1ToMaxNDigits_Recursely(str, n, 0);
		}

	}

	// 构造一个递归函数
	public void print1ToMaxNDigits_Recursely(StringBuffer str, int n, int index) {
		if (index == n - 1) {
			printNumber(str);
		}

		for (int i = 0; i < 10; i++) {
			str.setCharAt(index, (char) (i + '0'));
		}
		print1ToMaxNDigits_Recursely(str, n, index + 1);
	}

	// 打印数字，从第一个非0的字符开始打印
	public void printNumber(StringBuffer str) {
		boolean isBeginning0 = true;
		for (int i = 0; i < str.length(); i++) {
			if (isBeginning0 && str.charAt(i) != '0')
				isBeginning0 = false;
			if (!isBeginning0) {
				System.out.println(str.charAt(i));
			}
		}
	}

	public static void main(String[] args) {
		T16 a = new T16();
		a.print1ToMaxNDigits_3(1);
	}

}
