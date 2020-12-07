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
		 if(nums.length==0) return 0;
		  // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
	public static void main(String[] args) {
		int k = 23+(82-23)>>1;
		int j = (82+23)>>1;
		int a = (82+23)/2;
		int b = 23+(82-23)/2;
		System.out.println(k);
		System.out.println(j);
		System.out.println(a);
		System.out.println(b);
	}

}
