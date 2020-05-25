package 位运算;

import java.util.Arrays;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
//请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//示例 1：
//
//输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
//示例 2：
//
//输入：nums = [1,2,10,4,1,4,3,3]	
//输出：[2,10] 或 [10,2]
public class T54 {
	public static int[] singleNumbers(int[] nums) {
		int mask = 1;
		int k = 0;
		int a = 0, b = 0;
//		num1:       101110      110     1111
//		num2:       111110      001     1001
//		num1^num2:  010000      111     0110
//
//		可行的mask:  010000      001     0010
//		                        010     0100
//		                        100    
		for (int i : nums) {
			k ^= i;
		}
		// 分组的依据 找出这两个不同数的 最低位的不同数值
		while ((k & mask) == 0) {
			mask <<= 1;
		}
		// 相同的数字肯定为同一组
		for (int i : nums) {
			if ((i & mask) == 0) {
				a ^= i;
			} else {
				b ^= i;
			}
		}
		return new int[] { a, b };
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4,1,4,6};
		System.out.println(Arrays.toString(singleNumbers(a)));
	}
}
