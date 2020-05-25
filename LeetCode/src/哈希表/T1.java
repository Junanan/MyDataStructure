package 哈希表;

import java.util.HashMap;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//说明：
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//示例 1:
//输入: [2,2,1]
//输出: 1
//示例 2:
//输入: [4,1,2,1,2]
//输出: 4
public class T1 {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(Integer i:nums ) {
			Integer count = map.get(i);
			count = count ==null?1:++count;///别写成count++
			map.put(i, count);
		}
		for(Integer i:map.keySet()) {
			Integer p = map.get(i);
			if(p==1) return i; 
		}
		return -1;
    }
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,34,5};
		for(int i : nums) {
			System.out.println(i);
		}
	}

}
