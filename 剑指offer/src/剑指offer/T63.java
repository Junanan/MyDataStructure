package 剑指offer;

import java.util.HashMap;
import java.util.Map;

//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
//2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//
//示例 1:
//
//输入: [1,2,3,4,5]
//输出: True
// 
//
//示例 2:
//
//输入: [0,0,1,2,5]
//输出: True
public class T63 {
	public static boolean isStraight(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int min = 14;
		int max = 0;
		for (Integer num : nums) {
			if (num == 0)
				continue;
			if (map.containsKey(num))
				return false;
			map.put(num, num);
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		return max-min<5?true:false;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5};
		System.out.println(isStraight(nums));
	}
}
