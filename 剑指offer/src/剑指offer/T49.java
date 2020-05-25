package 剑指offer;
//统计一个数字在排序数组中出现的次数。
//
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//示例 2:
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
public class T49 {
	public static int search(int[] nums, int target) {
		int i = 0 ;
		int j = nums.length-1;
		//从右向左找
		while(i<=j) {
			int m = (i+j)/2;
			if (target>nums[m]) i = m+1;
			else if (target == nums[m]) j = m -1; //因为是找左边界 所以缩小右边范围
			else j = m -1;
		}
		int left = j;
		i =0;  j = nums.length-1; 
		while(i<=j) {
			int m = (i+j)/2;
			if (target>nums[m]) i = m+1;
			else if (target == nums[m]) i = m + 1;
			else j = m -1;
		}
		int right = i;
		return right - left -1;
    }
	public static void main(String[] args) {
		int[] nums = new int[] {5,7,7,8,8,10};
		System.out.println(search(nums,6));
	}

}
