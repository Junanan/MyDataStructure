package ��ָoffer;
//���ǰ�ֻ�������� 2��3 �� 5 ��������������Ugly Number�����󰴴�С�����˳��ĵ� n ��������
//ʾ��:
//
//����: n = 10
//���: 12
//����: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
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
	//  ���� = ��С����*ĳ���ӣ�2,3,5��
	public static void main(String[] args) {
		int [] a =new int[] {1,2,3,4,5};
		for(int i=0;i<a.length;++i) {
			System.out.println(a[i]);
		}
	}
}
