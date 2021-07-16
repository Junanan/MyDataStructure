package ���ݷ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//����һ������?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
//
//candidates?�е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
//
//˵����
//
//�������֣�����Ŀ������������������
//�⼯���ܰ����ظ�����ϡ�?
//ʾ��?1:
//
//����: candidates =?[10,1,2,7,6,1,5], target =?8,
//����⼯Ϊ:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//ʾ��?2:
//
//����: candidates =?[2,5,2,1,2], target =?5,
//����⼯Ϊ:
//[
//? [1,2,2],
//? [5]
//]
public class L40�������2 {
	static List<List<Integer>> res;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrack(candidates, list, target, 0);
		return res;
	}

	private static void backtrack(int[] candidates, List<Integer> list, int target, int j) {
		if (listsum(list) == target&&!res.contains(list)) {
			res.add(new ArrayList<>(list));
			return;
		}
		if(listsum(list)>target) return;
		for (int i = j; i < candidates.length; i++) {
			list.add(candidates[i]);
			backtrack(candidates, list, target, i+1);  /// �����ظ�ʹ������ ����һ�����ֿ�ʼѡ��
			list.remove(list.size() - 1);
		}
	}

	private static int listsum(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] candidates = new int[] { 10,1,2,7,6,1,5 };
		int target = 8;
		System.out.println(combinationSum2(candidates, target));
	}
}
