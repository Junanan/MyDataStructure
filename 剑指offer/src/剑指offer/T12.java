package 剑指offer;

import java.awt.datatransfer.SystemFlavorMap;
import org.omg.CORBA.TIMEOUT;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
//请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//示例 1：
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//示例 2:
//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
public class T12 {
	// 动态规划，从上往下的分解问题，得到若干个子问题，再求出这些这问题的最优解，在将他们储存起来
	// 第一个for循环表示从底向上 第二个for求出子问题的最优解，product储存最优解
	public static int cutRope(int target) {
		// 排除特殊情况
		if (target < 2) {
			return 0;
		}
		if (target == 2) {
			return 1;
		}
		if (target == 3) {
			return 2;
		}
		int[] products = new int[target + 1];
		///// 这些为初始值 直接当成数组形式的 0,1,2,3；
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		for (int i = 4; i <= target; i++) {
			int max = 0;
			///// i/2 像 （1,3） （3,1） 结果一样所以减半
			for (int j = 1; j <= i / 2; j++) {
				int product = products[j] * products[i - j];
				max = Math.max(max, product);////// ！！
			}
			products[i] = max;
		}
		return products[target];
	}

	// 暴力递归
	public static int cutRopee(int target) {
		if (target < 2) {
			return 0;
		}
		if (target == 2) {
			return 1;
		}
		if (target == 3) {
			return 2;
		}
		int max = cutRope03Core(target);
		return max;
	}

	private static int cutRope03Core(int target) {
		if (target < 4)
			return target;
		int max = 0;
		for (int i = 1; i <= target / 2; i++) {
			max = Math.max(cutRope03Core(i) * cutRope03Core(target - i), max);
		}
		return max;
	}

	////// 贪心算法
	public int cuttingRope(int n) {
		if (n <= 3)
			return n - 1;
		int a = n / 3, b = n % 3;
		if (b == 0)
			return (int) Math.pow(3, a);
		if (b == 1)
			return (int) Math.pow(3, a - 1) * 4;
		return (int) Math.pow(3, a) * 2;
	}

}
