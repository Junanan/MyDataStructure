package ���ֲ���;

public class L7������ת {
	class Solution {
	    public int reverse(int x) {
	        int ans = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
	                return 0;
	            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
	                return 0;
	            ans = ans * 10 + pop;
	            x /= 10;
	        }
	        return ans;
	    }
	}
//	��ans * 10 + pop > MAX_VALUE��������������
//	������ ans > MAX_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
//	������ ans == MAX_VALUE / 10 �� pop > 7 ʱ����һ�������7��2^31 - 1�ĸ�λ��  2147483647
//	��ans * 10 + pop < MIN_VALUE��������������
//	������ ans < MIN_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
//	������ ans == MIN_VALUE / 10 �� pop < -8 ʱ����һ�������8��-2^31�ĸ�λ�� -2147483648
	public static int reversee(int x) {
		try {
		String a = String.valueOf(x);
		if(a.length()==1) return x;
		int index = 1;
		while(a.charAt(a.length()-index)=='0') index++;
		a = a.substring(0, a.length()-index+1);
		char[] b = a.toCharArray();
		int i = b[0]=='-'?1:0;
		int j = a.length() - 1;
		while (i < j) {
			swap(b, i, j);
			i++;
			j--;
		} 
		return Integer.valueOf(String.valueOf(b));
		}catch (Exception e) {
			return 0;
		}
	}

	private static void swap(char[] b, int i, int j) {
		char temp = b[i];
		b[i] = b[j];
		b[j] = temp;
	}

	public static void main(String[] args) {
		String a = "1213200";
		System.out.println(Integer.MAX_VALUE);
	}
}
