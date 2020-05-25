package ˫ָ��;

import java.util.Arrays;

//����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s�����������һ�Լ��ɡ�
//ʾ�� 1��
//���룺nums = [2,7,11,15], target = 9
//�����[2,7] ���� [7,2]
//ʾ�� 2��
//
//���룺nums = [10,26,30,31,47,60], target = 40
//�����[10,30] ���� [30,10]
public class T56 {
	  public static int[] twoSum(int[] nums, int target) {
		  int i =0 ;
		  int j =nums.length-1 ;
		  while(i<j) {
			  if(nums[j]+nums[i]>target) j--;
			  else if(nums[j]+nums[i]<target)i++;
			  else return new int[] {nums[i],nums[j]};
		  }
		  // return new int[0];
		  throw new IllegalArgumentException("�����������");
	    }
//	  ����˼·��
//	  ���� HashMap ����ͨ�����������ҵ�������ϣ�ʱ��Ϳռ临�ӶȾ�Ϊ O(N)O(N) ��
//	  ע�Ȿ��� numsnums �� �������� ����˿�ʹ�� ˫ָ�뷨 ���ռ临�ӶȽ����� O(1)O(1) ��
	  public static void main(String[] args) {
		int[] a = new int[] {2,7,11,15};
		System.out.println(Arrays.toString(twoSum(a,9)));
	}
}
