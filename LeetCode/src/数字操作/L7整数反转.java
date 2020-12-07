package 数字操作;

public class L7整数反转 {
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
//	从ans * 10 + pop > MAX_VALUE这个溢出条件来看
//	当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
//	当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数  2147483647
//	从ans * 10 + pop < MIN_VALUE这个溢出条件来看
//	当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
//	当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数 -2147483648
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
