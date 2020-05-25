package 剑指offer;

import java.util.Arrays;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//示例 1:
//
//输入: [10,2]
//输出: "102"
//示例 2:
//
//输入: [3,30,34,5,9]
//输出: "3033459"
public class T42 {
	public static String minNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for (String i : strs) {
			res.append(i);
		}
		return res.toString();
	}
	public static String minNumberr(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		quicksort(strs, 0, strs.length - 1);
		StringBuilder res = new StringBuilder();
		for (String i : strs) {
			res.append(i);
		}
		return res.toString();
	}

	static void quicksort(String[] strs, int low, int hight) {
		if (low >= hight)
			return;
		int i = low;
		int j = hight;
		String stard = strs[low];
		while (i < j) {
			while (i < j && (strs[j] + stard).compareTo(stard + strs[j]) >= 0) {
				j--;
			}
			while (i < j && (strs[i] + stard).compareTo(stard + strs[i]) <= 0) {
				i++;
			}

			String temp = strs[i];
			strs[i] = strs[j];
			strs[j] = temp;
		}
		strs[low] = strs[i];
		strs[i] = stard;
		quicksort(strs, low, i - 1);
		quicksort(strs, i + 1, hight);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 30, 34, 5, 9 };
		String[] b = new String[] { "sd", "123" };
		System.out.println(b.toString());
		System.out.println(minNumberr(a));
	}
}
