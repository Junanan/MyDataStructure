package ��ָoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//����һ�������� target ��������к�Ϊ target ���������������У����ٺ�������������
//
//�����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
//
//ʾ�� 1��
//
//���룺target = 9
//�����[[2,3,4],[4,5]]
//ʾ�� 2��
//
//���룺target = 15
//�����[[1,2,3,4,5],[4,5,6],[7,8]]
public class T57 {
	public static int[][] findContinuousSequence(int target) {
		int i=1,j=1;
		int sum =0;
		List<int[]> res = new ArrayList<>();
		while(i<=target/2) // ��ĿҪ������������ ������������   ��i = target/2 i+1= target/2+1  �����������������Ѿ�����target
		{
			if(sum<target) {
				sum+=j;
				j++;
			}else if(sum>target) {
				sum-=i;
				i++;
			}else {
				int[] temp = new int[j-i];
				for(int k=i;k<j;k++) {
					temp[k-i] = k; 
				}
				res.add(temp);
				sum-=i;
				i++;
			}
//		return res.toArray(new int[res.size()][]);
	}
		int[][] a = new int[res.size()][];
		return res.toArray(a);
}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(findContinuousSequence(15)));
	}

}
