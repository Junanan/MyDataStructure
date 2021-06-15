package ��̬�滮;

public class L01�������� {
	public static void main(String[] args) {
		int[] wt = {  2, 1, 3 };
		int[] val = { 4, 2, 3 };
		System.out.println(kProblem(3, 4, wt, val));

	}

	public static int kProblem(int n, int w, int[] wt, int[] val) {
//		dp[i][w]��ʾ������ǰi����Ʒ����ǰ����������Ϊwʱ����������¿���װ�µ�����ֵ��dp[i][w]��
		int[][] dp = new int[n + 1][w + 1];
		// ��ʼ�� ������۸�Ϊ0 ������
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= w; i++) {
			dp[0][i] = 0;
		}
		dp[0][0] = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j - wt[i-1] < 0) {// ���� ֻ��ѡ��װ
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i-1]] + val[i-1]);
// ��ȫ������	dp[i][j] = Math.max(dp[i - 1][j], dp[i] [j - wt[i-1]] + val[i-1]);
//��������������Ʒ�ܲ����ظ�ʹ��
				}
			}
		}
		return dp[n][w];
	}
	//��ȫ���� L322��Ǯ
}