package 动态规划与贪婪算法;

public class T13 {
	// 剪绳子II 题目不变答案取模1000000007
	public static int cuttingRope(int n) {
		if (n < 2) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		if (n == 3)
			return 2;
		int max = 0;
		max = cut(n);
		return max % 1000000007;
	}

	private static int cut(int i) {
		if (i < 4)
			return i;
		int maxvl = 0;
		for (int k = 1; k <= i / 2; k++) {
			maxvl = Math.max(cut(k) * cut(i - k), maxvl);
		}
		return maxvl;
	}

	public static int cuttingRopee(int n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int[] p = new int[n + 1];

		p[0] = 0;
		p[1] = 1;
		p[2] = 2;
		p[3] = 3;
		for (int i = 4; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= i / 2; j++) {
				int pp = p[j] * p[i - j];
				max = Math.max(pp, max);
			}
			p[i] = max;
		}
		return p[n] % 1000000007;
	}

	public static int cuttingRopeee(int n) {
		if (n <= 3) {
			return n - 1;
		}
		int r = n % 3;
		long ref = 1l;

		for (int i = 0; i < n / 3 - 1; i++) {
			ref = (ref * 3) % 1000000007;
		}

		if (r == 0) {
			ref = (ref * 3) % 1000000007;
		} else if (r == 1) {
			ref = (ref * 4) % 1000000007;
		} else if (r == 2) {
			ref = (ref * 6) % 1000000007;
		}
		return (int) ref;
	}

	public static void main(String[] args) {
//		System.out.println(cuttingRope(30));
		System.out.println(cuttingRopee(500));
		System.out.println(cuttingRopeee(500));
	}

}
