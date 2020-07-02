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
		int[] dp = new int[target + 1]; //因为i 可以等于 绳子的长度 所以数组长度 为绳长+1；
		dp[2] = 1;
		for (int i = 3; i <= target; i++) {			
			for (int j = 1; j <= i; j++) {   // j!=i 因为dp[0] = 0  可等可不等
//				i * (n - i) 表示剪成两段，i * F(n - i) 表示分成将 n- i的这段继续剪。
				dp[i] = Math.max(dp[i],Math.max(j * dp[i - j], j * (i - j)));
			}
		}
		return dp[target];
	}
	///  递归与递推的区别
	// 暴力递归
	public static int cutRopee(int target) {
		    if (target == 2) {
		        return 1;
		    }
		    int res = -1;
		    for (int i = 1; i <= target - 1; i++) {
		        res = Math.max(res, Math.max(i * (target - i), i * cutRopee(target - i)));
		    }
		    return res;
		}

	// 记忆化搜索-自顶向下
	static int[] dp;
	public static int cutRop(int n) {
	    dp = new int[n + 1];
	    return cutRoper(n);
	}
	public static int cutRoper(int n) {
	    if (n == 2) {
	        return 1;
	    }
	    // dp的初始值为0，如果它不为0，说明已经计算过了，直接返回即可
	    if (dp[n] != 0) {
	        return dp[n];
	    }
	    int res = -1;
	    for (int i = 1; i <= n - 1; i++) {
	        res = Math.max(res, Math.max(i * cutRoper(n - i), i * (n - i)));
	    }
	    // 将每次计算的结果保存到备忘录数组中
	    dp[n] = res;
	    return res;
	}

	public static void main(String[] args) {
		System.out.println(cutRop(10));
	}
}
