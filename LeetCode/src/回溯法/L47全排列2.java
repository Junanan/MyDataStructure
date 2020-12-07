package ���ݷ�;

import java.util.ArrayList;
import java.util.List;

//����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
//
//ʾ��:
//
//����: [1,1,2]
//���:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class L47ȫ����2 {
	static List<List<Integer>> res;

	public static List<List<Integer>> permuteUnique(int[] nums) {
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		boolean[] isValid = new boolean[nums.length];
		backtrack(list, nums, isValid);
		return res;
	}

	private static void backtrack(List<Integer> list, int[] nums, boolean[] isValid) {
		if (list.size() == nums.length && !res.contains(list)) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {  /// ����ҪStart  ��Ϊ��ȫ����
			if (isValid[i])
				continue;
			if(i>0&&nums[i]==nums[i-1]&&isValid[i-1]) break;//��֦ û��Ҳ�� ����ʱ����� (�����ʵ)
			isValid[i] = true;
			list.add(nums[i]);
			backtrack(list, nums, isValid);
			isValid[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}
}
