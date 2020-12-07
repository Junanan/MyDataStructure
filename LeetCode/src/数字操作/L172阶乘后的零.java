package 数字操作;

import java.math.BigInteger;

//给定一个整数 n，返回 n! 结果尾数中零的数量。
//
//示例 1:
//
//输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。
//示例 2:
//
//输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零.
//说明: 你算法的时间复杂度应为 O(log n) 。
//
public class L172阶乘后的零 {
	/// 找有多少对2*5 而2的出现的次数远比5多 所以只需要找5出现的次数
	public int trailingZeroes(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n / 5;
			n /= 5;
		}
		return sum;
	}
	public static long recus(int n) {
		if(n==0) return 1;
		return n*recus(n-1);
	}
	public static void main(String[] args) {
		System.out.println(recus(15));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}
