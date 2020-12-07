package 剑指offer;

import java.util.ArrayList;
import java.util.List;

//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
//
//例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
//则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
//
// 
//
//示例 1：
//
//输入: n = 5, m = 3
//输出: 3
//示例 2：
//
//输入: n = 10, m = 17
//输出: 2
public class T64 {
	public static int lastRemaining(int n, int m) {
		//Review分割线
		int res = 0;
		int k =1;
		while(k<n) {
			k++;
			res = (res+m)%k;
		}
		return res;
    }
	public static int lastRemainingg(int n, int m) {
		//超时
		List<Integer> res = new ArrayList<>();
		int k =0;
		for(int i = 0;i<n;i++) {
			res.add(i);
		}
		while(n>1) {
			k = (k+m-1)%n;
			res.remove(k);
			n--;
		}
		return res.get(0);
	}
	public static void main(String[] args) {
		System.out.println(lastRemaining(10,17));
		System.out.println(lastRemainingg(10,17));
	}
}
