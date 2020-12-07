package ���ݷ�;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
//
//ʾ��:
//
//����: [1,2,3]
//���:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class L46ȫ���� {
	List<List<Integer>> res;
	public List<List<Integer>> permute(int[] nums) {
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtracking(nums,list);
		return res;
    }
//	list ���������ָ��Ķ����ڵݹ�Ĺ�����ֻ��һ�ݣ�������ȱ�������Ժ���Ϊ�ص��˸���㣨��Ϊ����֮ǰ˵�ˣ��������ص�ǳ�����ʱ����Ҫ����֮ǰ��ѡ�񣩣�
//	 ��Щ��ַ����ӵ� res ��������ʵ����ָ�����ͬһ���ڴ��ַ��������ǻῴ�� 6 ���յ��б���󡣽���ķ����ܼ򵥣��� res.add(list); ������һ�ο�������
	private void backtracking(int[] nums, List<Integer> list) {
		if(list.size()==nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i =0;i<nums.length;i++) {
			if(list.contains(nums[i])) continue;
		list.add(nums[i]);
		backtracking(nums, list);///������һ������
		list.remove(list.size()-1);////������ǰ���ߵ�ѡ��
		}
	}
	
}
