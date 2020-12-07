package 剑指offer;

import java.util.Arrays;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//示例：
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。
public class T19调整数组顺序使奇数位于偶数前面 {
	//双指指针法
	public static int[] exchange(int[] nums) {
		int i=0;//左指针
		int j=nums.length-1;//右指针
		while(i<j) {
			if((nums[i] & 1)==1) {
				i++;
				continue;//////
			}
			if((nums[j] & 1)==0) {
				j--;
				continue;
			}
			swap(nums,i,j);  /////错误的交换 swap(i,j)
		}
		return nums;
    }
//	private static void swapp(int i, int j) {
//		int temp = i;
//		 i =j;
//		 j= temp;
	private static void swap(int[] nums,int i, int j) {
		int temp = nums[i];
		   nums[i] = nums[j];
		   nums[j] = temp;
		   return;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4};
		System.out.println(Arrays.toString(exchange(nums)));
	}

}
