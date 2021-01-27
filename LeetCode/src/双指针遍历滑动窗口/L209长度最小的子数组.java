package 双指针遍历滑动窗口;
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
//如果不存在符合条件的连续子数组，返回 0。
//
//示例：
//
//输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
public class L209长度最小的子数组 {
	 public static int minSubArrayLen(int s, int[] nums) {
		int fastIndex=1;
		int slowIndex=0;
		int sum = nums[slowIndex] + nums[fastIndex];
		while(fastIndex < nums.length){
			if(isTure(nums,fastIndex)){
				sum += nums[fastIndex];
				int i = slowIndex;
				int j = fastIndex;
				while(i < j){
					if(sum > s ){

					}
				}
			}else{
				slowIndex = fastIndex;
				sum  = nums[slowIndex];
			}
			fastIndex ++ ;
		}
		return 0;
	}

	private static boolean isTure(int[] nums, int fastIndex) {
	 	if(nums[fastIndex-1]+1 == nums[fastIndex]){
	 		return true;
		}else if (nums[fastIndex-1]-1 == nums[fastIndex]){
	 		return true;
		}else{
	 		return false;
		}
	}
//	 移动窗口的套路
//	 扩张窗口：找可行解，找到了就不再扩张
//	 收缩窗口：在长度上优化该可行解，直到条件被破坏
//	 寻找下一个可行解，然后再优化……
}
