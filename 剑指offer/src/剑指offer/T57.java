package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//示例 1：
//
//输入：target = 9
//输出：[[2,3,4],[4,5]]
//示例 2：
//
//输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
public class T57 {
	public static int[][] findContinuousSequence(int target) {
		int i=1,j=1;
		int sum =0;
		List<int[]> res = new ArrayList<>();
		while(i<=target/2) // 题目要求至少两个数 而且是连续的   当i = target/2 i+1= target/2+1  这两个数加起来就已经大于target
		{
			if(sum<target) {
				sum+=j;
				j++;
			}else if(sum>target) {
				sum-=i;
				i++;
			}else {
				int[] temp = new int[j-i];
				for(int k=i;k<j;k++) {
					temp[k-i] = k; 
				}
				res.add(temp);
				sum-=i;
				i++;
			}
//		return res.toArray(new int[res.size()][]);
	}
		int[][] a = new int[res.size()][];
		return res.toArray(a);
}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(findContinuousSequence(15)));
	}

}
