package 位运算;
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
//示例 1:
//
//输入: 2
//输出: [0,1,1]
//示例 2:
//
//输入: 5
//输出: [0,1,1,2,1,2]
public class L338 {
	public int[] countBits(int num) {
		int[] dp = new int[num+1];
		dp[0] = 0;
		for(int i =1 ;i<=num;i++) {
			if((i&1)==1) {
				dp[i] = dp[i-1]+1;//奇数第一位为1 
			}else {
				dp[i] = dp[i/2]; //偶数第一位为0 右移一位消除0 
			}
		}
		return dp;
    }

}
