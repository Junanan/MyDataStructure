package ��ָoffer;

//����һ������ n ����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
//���磬����12��1��12��Щ�����а���1 ��������1��10��11��12��1һ��������5�Ρ�
//ʾ�� 1��
//���룺n = 12
//�����5
//ʾ�� 2��
//
//���룺n = 13
//�����6
public class T40 {
	public static int countDigitOne(int n) {
		if (n == 0)
			return 0;
		return dfs(n);
	}
//�ֶ���֮
	private static int dfs(int n) {
		if (n == 0)
			return 0;
		String s = String.valueOf(n);
		int high = s.charAt(0) - '0';//��ȥ0��ascII�� �ó���0��λ���ַ���intֵ
		int pow = (int) Math.pow(10, s.length() - 1);
		int last = n - high * pow;
		if (high == 1)
			return dfs(pow - 1) + last + 1 + dfs(last);
		else
			return pow + high * dfs(pow - 1) + dfs(last);
	}
	public static void main(String[] args) {
		int a = 1234;
		System.out.println(countDigitOne(a));
	}
}
