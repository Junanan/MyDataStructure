package 动态规划;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//注意：给定 n 是一个正整数。
//
//示例 1：
//
//输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//示例 2：
//
//输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
public class L70 {
	 public int climbStairss(int n) {
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        dp[1] = 1;/// 边界条件
	        for(int i = 2; i <= n; i++) {
	            dp[i] = dp[i - 1] + dp[i - 2];   //转移方程
	        }
	        return dp[n];
	    }
//	本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
//  倒过来想
//	爬上 n-1阶楼梯的方法数量。因为再爬1阶就能到第n阶
//	爬上 n-2阶楼梯的方法数量，因为再爬2阶就能到第n阶
//	所以我们得到公式 dp[n] = dp[n-1] + dp[n-2]
//	同时需要初始化 dp[0]=1和 dp[1]=1

	 public int climbStairs(int n) {
	        if(n==1) return 1;
	        int a = 1;
	        int b = 1;
	        int sum =0;
	        for(int i =1 ;i<n;i++){
	            sum = a +b ;
	             b = a ;
	             a = sum; 
	        }
	        return a ;

	    }
	 //暴力搜索
	 public int climbStair(int n) {
	        return climb_Stairs(0, n);
	    }
	    public int climb_Stairs(int i, int n) {
	        if (i > n) {
	            return 0;
	        }
	        if (i == n) {
	            return 1;
	        }
	        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
	    }
}
