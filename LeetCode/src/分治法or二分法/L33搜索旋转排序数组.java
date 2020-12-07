package 分治法or二分法;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//你可以假设数组中不存在重复的元素。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//示例 1:
//
//输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//示例 2:
//
//输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
public class L33搜索旋转排序数组 {
//	先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段，接下来再判断 target 是在 mid 的左边还是右边，从而来调整左右边界 lo 和 hi。
	public int search(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		//// 分成两段进行二分法搜索,判断target在那个区间
		while (i <= j) {
			int mid = (i + j) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] >= nums[i]) {
				if (target >= nums[i] && target <= nums[mid]) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			} else { 
				if (target >= nums[mid] && target <= nums[j]) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			}
		}
		return -1;
	}
}
