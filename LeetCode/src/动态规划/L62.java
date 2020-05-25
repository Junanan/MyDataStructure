package ��̬�滮;
//һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
//
//������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
//
//���ܹ��ж�������ͬ��·����
public class L62 {
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[n][m];
		for(int i =1 ;i<m;i++) {
			dp[0][i] =1;
		}
		for(int i =1 ;i<n;i++) {
			dp[i][0] =1;
		}
		for(int i =1;i<n;i++) {
			for(int j =1;j<m;j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[n-1][m-1];
    }
	public static void main(String[] args) {
		System.out.println(uniquePaths(7,3));
	}
	
}
