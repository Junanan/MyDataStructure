package Daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
//
//如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
//
//请你返回排序后的数组。
//
// 
//
//示例 1：
//
//输入：arr = [0,1,2,3,4,5,6,7,8]
//输出：[0,1,2,4,8,3,5,6,7]
//解释：[0] 是唯一一个有 0 个 1 的数。
//[1,2,4,8] 都有 1 个 1 。
//[3,5,6] 有 2 个 1 。
//[7] 有 3 个 1 。
//按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
public class L1356根据数字二进制下1的数目排序 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1})));
	}
	public static int[] sortByBits(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		for (int i : arr) {
			int count = getCount(i);
			map.put(i, count);
			list.add(i);
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				 if (map.get(o1) != map.get(o2)) {
	                    return map.get(o1) - map.get(o2);
	                } else {
	                    return o1 - o2;
	                }
			}
		});;
		int k = 0;
		for (int i : list) {
			arr[k++] = i;
		}
		return arr;
	}

	private static int getCount(int i) {
		int count = 0;
		while (i != 0) {
			if ((i & 1) == 1) {
				count ++;
				i >>= 1;
			}else {
				i >>= 1;
			}
		}
		return count;
	}
}
