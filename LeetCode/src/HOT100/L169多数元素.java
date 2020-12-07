package HOT100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

//
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 
//
//示例 1:
//
//输入: [3,2,3]
//输出: 3
//示例 2:
//
//输入: [2,2,1,1,1,2,2]
//输出: 2
public class L169多数元素 {
	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
	//摩尔投票法
	public int majorityElement2(int[] nums) {
		int flag = nums[0];
		int count =0;
		for(int i=1;i<nums.length;i++) {
			if(flag==i)count++;
			else count--;
			if(count==0) { // 更换新的候选人
				flag = nums[i];
				i++;
				count =1;
			}
		}
		return flag;
    }
	 public static int findRepeatNumber(int[] nums) {
	        if(nums.length==0) return 0;
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for(int i:nums){
	            if(map.containsKey(i)){
	                int count = map.get(i);
	                map.put(i,count++);
	                if(map.get(i)>1) return i;
	            }else{
	                map.put(i,1);
	            }
	        }
	        return 0;
	    }
	 public static void main(String[] args) {
//		 TreeMap<Integer,Integer> map = new TreeMap<>();
//		 map.put(6, 2);
//		 map.put(2, 9);
//		 map.put(1, 1);
//		 System.out.println(map.keySet());
////		System.out.println(majorityElement(new int[] {3,3,4}));
//		 System.out.println(findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));
//		 boolean[][] is = new boolean[2][2];
//	        for(boolean[] i:is){
//	            Arrays.fill(true, i);
//	        }
	}
}
