package 剑指offer;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
//一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//示例 1:
//输入: 12258 
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
public class T43 {
	static int count = 0;

	public static int translateNum(int num) {
		String a = String.valueOf(num);
		backtracking(a, 0);
		return count;
	}

	private static void backtracking(String a, int i) {
		if (i >= a.length()) {
			count++;
			return;
		}
		backtracking(a, i+1);
		if(i<a.length()-1&&a.substring(i, i+1)!="0"&&(Integer.valueOf(a.substring(i, i+2))>=0&&(Integer.valueOf(a.substring(i, i+2))<=25))){
			backtracking(a, i+2);
		}
	}

	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}

}
