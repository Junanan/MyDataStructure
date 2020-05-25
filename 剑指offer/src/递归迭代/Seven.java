package 递归迭代;

public class Seven {
//	写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
//	F(0) = 0,   F(1) = 1
//	F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//	斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
//	答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//递归法重复度高，耗时长
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

//动态规划法
	public static int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		int a = 0, b = 1, sum = 0;
		// f(n+1) = f（n）+ f(n-1)
		for (int i = 0; i < n; i++) {
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return a;// 返回f(n)
	}

	public static void main(String[] args) {
		int a = fib(8);
		System.out.println(a);
		System.out.println(Fibonacci(8));
	}

}
