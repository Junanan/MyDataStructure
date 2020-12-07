package 数组操作;
import java.util.Arrays;
import java.util.HashMap;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//示例:
//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
public class T1 {
	public static int[] twoSum(int[] nums, int target) {
		int[] res  =new int[2];
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		for(int i=0 ; i<nums.length;i++) {
			hashmap.put(nums[i], i);
		}
		for(int i = 0;i<nums.length;i++) {
			int temp = target - nums[i];
			if(hashmap.containsKey(temp)&&hashmap.get(temp)!=i) {
				res[0] =hashmap.get(temp);
				res[1] =i ;
				return res;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
    }
	public static int[] twoSumm(int[] nums, int target) {
		int[] res  =new int[2];
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		// //遍历数组，将元素存储进哈希表,同时回过来查找是否存在另一个满足条件的元素。
		for(int i=0;i<nums.length;i++) {
			int temp = target - nums[i];
			if(hashmap.containsKey(temp)) {
				//哈希表存在该元素
				res[0] = hashmap.get(temp);
				res[1] = i;
				return res;
			}
			hashmap.put(nums[i],i );
		}
		throw new IllegalArgumentException("No two sum solution");
		
		
	}
	public static void main(String[] args) {
		int [] a  = new int[] {5,2,3,5};
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(5, 1);
		map.put(5, 2);
		map.put(5, 3);
		map.put(5, 4);
		System.out.println(map.get(5));
		System.out.println(Arrays.toString(twoSum(a, 10)));
 	}
}
