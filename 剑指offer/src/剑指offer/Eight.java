package 剑指offer;

public class Eight {
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//示例 1：
//
//输入：n = 2
//输出：2
//示例 2：
//
//输入：n = 7
//输出：21
	public static int fib(int n) {
		int a = 1;
		int b = 1;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (a + b) % 1000000007;
			b = a;
			a = sum;
		}
		return a;
	}
//青蛙在最后一阶台阶只有两种跳法  剩1阶 为f(n-1)种跳法 剩2阶 为f(n-2)种跳法 所以 f(n) = f(n-1) + f(n-2)  递归转移 	f(n+1) = f(n) + f(n-1);
	// 与斐波那契不一样的是 菲波那切数列 f(0) = 0 f(1) =1 而青蛙 f(0) =1 f(1) =1
}
