package 剑指offer;

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
//在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//示例 1:
//输入: [0,1,3]
//输出: 2
//示例 2:
//输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
public class T50 {
	public static int missingNumber(int[] nums) {
		if (nums == null)
			return -1;
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int m = (i + j) >> 1;
			if (nums[m] == m)
				i = m + 1;
			else
				j = m - 1;
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 9,10,11}));
	}

}
