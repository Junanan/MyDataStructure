package HOT100;
public class L33ËÑË÷Ğı×ªÅÅĞòÊı×é {
	public int search(int[] nums, int target) {
		int i=0;
		int j=nums.length-1;
		while(i<j) {
		int mid = i + (j-i)/2; 
			if(target == nums[mid]) return mid;
			if(nums[mid]>=nums[i]) {
				if(target<nums[mid]&&target>=nums[i]) {
					j= mid-1;
				}else {
					i = mid +1;
				}
			}else {
				if(target>nums[mid]&&target<=nums[j]) {
					i = mid +1;
				}else{
					j= mid-1;
				}
			}
		}
		if(nums[i]==target) return i;
		return -1;
    }
}
