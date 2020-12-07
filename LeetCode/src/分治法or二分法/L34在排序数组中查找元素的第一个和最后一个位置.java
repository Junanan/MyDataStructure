package 分治法or二分法;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。
//示例 1: 
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
public class L34在排序数组中查找元素的第一个和最后一个位置 {
	/// 运用二分法寻找边界
	 public static int[] searchRange(int[] nums, int target) {
		  if(nums.length==0) return new int[] {-1,-1};
			 int[] res = new int[2];
			 res[0] = searchleft(nums,target);
			 res[1] = searchright(nums,target);
		     return res;
		   }

		private static int searchleft(int[] nums, int target) {
			 int i =0;
			 int j = nums.length-1;
			 int mid = 0;
			 while(i<=j) {
				 mid = (i+j)/2;
				 if(nums[mid]<target) {
					 j = mid -1;
				 }else if(nums[mid]>target) {
					 j = mid -1;
				 }else {
					 j = mid -1;
				 }
			 }
			 if(i>=nums.length||nums[i]!=target) return -1;///////s
			return i;//////
		}

		private static int searchright(int[] nums, int target) {
			 int i =0;
			 int j = nums.length-1;
			 int mid = 0;
			 while(i<=j) {
				 mid = i+(j-i)/2; ///与(i+j)/2 结果相同 但是有效的防止了i+j 结果溢出的情况
				 if(nums[mid]<target) {
					 i = mid +1;
				 }else if(nums[mid]>target) {
					 j = mid -1;
				 }else {
					 i = mid +1;
				 }
			 }
			 if(j<0||nums[j]!=target) return -1;
			return j;	
		}
	public static void main(String[] args) {
		searchRange(new int[] {5,7,7,8,8,10},8);
	}
}
