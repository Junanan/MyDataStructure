package �ݹ�;

import java.util.LinkedList;
import java.util.List;

public class ���仯�ݹ� {
	
	// ������¼�ĵݹ� �Զ�����   Roddcutting
		public static int memorizedCutRod(int n, int[] princes) {
			int[] dp = new int[n + 1];
			for (int i = 0; i <=n; i++) {
				dp[i] = -1;
			}
			return memorized(n, princes, dp);
		}

		private static int memorized(int n, int[] princes, int[] dp) {
			if (dp[n] != -1)
				return dp[n];
			int q = -1;
			if (n == 0)
				q = 0;
			else {
				for (int i = 1; i <=n; i++) {
					q = Math.max(q, princes[i] + memorized(n - i, princes, dp));
				}
				dp[n] = q;
			}
			return q;
		}
		
		
		///쳲�����
		private int []memo;
	    public int fib(int N) {
	        // ʹ�ü��仯�ݹ�
	        memo = new int[N+1];
	        for(int i=1; i<=N; ++i)
	            memo[i] = -1;

	        return fibo(N);
	    }

	    private int fibo(int N){
	        if(N == 0)
	            return 0;
	        if(N == 1)
	            return 1;
	        if(memo[N] == -1)
	            memo[N] = fibo(N-1)+fibo(N-2);
	        return memo[N];
	    }
}
