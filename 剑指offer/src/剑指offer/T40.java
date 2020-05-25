package 剑指offer;

//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//示例 1：
//输入：n = 12
//输出：5
//示例 2：
//
//输入：n = 13
//输出：6
public class T40 {
	public static int countDigitOne(int n) {
		if (n == 0)
			return 0;
		return dfs(n);
	}
//分而治之
	private static int dfs(int n) {
		if (n == 0)
			return 0;
		String s = String.valueOf(n);
		int high = s.charAt(0) - '0';//减去0的ascII码 得出第0个位置字符的int值
		int pow = (int) Math.pow(10, s.length() - 1);
		int last = n - high * pow;
		if (high == 1)
			return dfs(pow - 1) + last + 1 + dfs(last);
		else
			return pow + high * dfs(pow - 1) + dfs(last);
	}
	public static void main(String[] args) {
		int a = 1234;
		System.out.println(countDigitOne(a));
	}
}
