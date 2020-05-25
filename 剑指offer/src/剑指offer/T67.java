package 剑指offer;
//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//
// 
//
//示例:
//
//输入: a = 1, b = 1
//输出: 2
public class T67 {
	public int add(int a, int b) {
		while(b!=0) {
			int c = (a&b)<<1;
			 a = a^b;
			 b = c;
		}
		return a ;
	}
	public static int add2(int a, int b) {
		if(a==0) return b;
		if(b==0) return a;
		int temp1=(a&b)<<1;
		int temp2=a^b;
		return add2(temp1,temp2);
	}
	public static void main(String[] args) {
		System.out.println(add2(4,6));
	}
}
