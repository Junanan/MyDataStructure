package HOT100;
//ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
//
//�����������һ����������У��������������г���С�����У����������У���
//
//����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
//
//������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
//1,2,3 �� 1,3,2
//3,2,1 �� 1,2,3
//1,1,5 �� 1,5,1

import java.util.Arrays;

public class L31��һ������ {
	public void nextPermutation(int[] nums) {
		for(int i=nums.length-2;i>=0;i--) {
			for(int j=nums.length-1;j>i;j--) {
				if(nums[j]>nums[i]) {
					swap(nums,i,j);
					Arrays.sort(nums,i+1,nums.length);
					return ;
				}
			}
		}
	Arrays.sort(nums);
    }

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
}
