package 剑指offer;
//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//示例:
//
//输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
public class T46 {
	public static int nthUglyNumber(int n) {
		int[] dp = new int[n];
		int a=0,b=0,c=0;
		dp[0] =1;
		for(int i=1;i<n;i++) { 
			int n2 = dp[a]*2,n3=dp[b]*3,n5=dp[c]*5;
			dp[i] =Math.min(Math.min(n2, n3), n5);
			if(dp[i]==n2) a++;
			if(dp[i]==n3) b++;
			if(dp[i]==n5) c++;
    }
		return dp[n-1];
	}
	//  丑数 = 较小丑数*某因子（2,3,5）
	public static void main(String[] args) {
		int [] a =new int[] {1,2,3,4,5};
		for(int i=0;i<a.length;++i) {
			System.out.println(a[i]);
		}
	}
}
