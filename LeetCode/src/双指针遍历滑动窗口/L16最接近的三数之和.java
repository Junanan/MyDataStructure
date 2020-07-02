package ˫ָ�������������;

import java.util.Arrays;

//����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
//
// 
//
//ʾ����
//
//���룺nums = [-1,2,1,-4], target = 1
//�����2
//���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��
public class L16��ӽ�������֮�� {
	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		int res = nums[0]+nums[1]+nums[2];
		for (int i = 0; i < len; i++) {
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum-target) < Math.abs(res-target) )
					res = sum;
				if (sum < target ) {
					left++;
				}else if (sum > target ) {
					right--;
				}else {
					return target;
				}
				
			}
		}
		return res;
	}
}
