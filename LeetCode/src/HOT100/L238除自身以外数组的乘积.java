package HOT100;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
// 
//
//示例:
//
//输入: [1,2,3,4]
//输出: [24,12,8,6]
public class L238除自身以外数组的乘积 {
	public int[] productExceptSelf2(int[] nums) {
		int len = nums.length;
		int[] arr = new int[len];
		int left = 1;
		int right = 1;
		for (int i = 0; i < len; i++) {
			arr[i] = left;
			left *= nums[i];
		}
		for (int j = len - 1; j >= 0; j--) {
			arr[j] *= right;
			right *= nums[j];
		}
		return arr;
	}

	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;

		// L 和 R 分别表示左右两侧的乘积列表
		int[] L = new int[length];
		int[] R = new int[length];

		int[] answer = new int[length];

		// L[i] 为索引 i 左侧所有元素的乘积
		// 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
		L[0] = 1;
		for (int i = 1; i < length; i++) {
			L[i] = nums[i - 1] * L[i - 1];
		}

		// R[i] 为索引 i 右侧所有元素的乘积
		// 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
		R[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			R[i] = nums[i + 1] * R[i + 1];
		}

		// 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
		for (int i = 0; i < length; i++) {
			answer[i] = L[i] * R[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] s = new int[] {3,30,34,5,9};
		System.out.println(minNumber(s));
		
	}

	public static String minNumber(int[] nums) {
		List<String> strList = new LinkedList<>();
		for (int num : nums) {
			strList.add("" + num);
		}
		Collections.sort(strList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < strList.size(); i++) {
			builder.append(strList.get(i));
		}
		return builder.toString();
	}

}
