package 剑指offer;

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//示例 1：
//
//输入: n = 3
//输出: 6
//示例 2：
//
//输入: n = 9
//输出: 45
public class T66 {
	static int res;
	public static int sumNums(int n) {
		boolean x = n >1 && sumNums(n-1)>0;
		res += n;
		return res;
		//运用了&& || 的短路机制
	}
	public static void main(String[] args) {
		System.out.println(sumNums(9));
	}
}
