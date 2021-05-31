package ����;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 3, 4};
        System.out.println(insersort(arr));
    }

    // ���������ȶ������ڽӽ����������£���������

	public static int[] insersort(int[] nums) {
		int len = nums.length;
		// ѭ������������ nums[i] ���뵽���� [0, i) ʹ֮��Ϊ��������
		for (int i = 1; i < len; i++) {
			// ���ݴ����Ԫ�أ�Ȼ��֮ǰԪ��������ƣ�������λ
			int temp = nums[i];
			int j = i;
			// ע��߽� j > 0
			while (j > 0 && nums[j - 1] > temp) {
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = temp;
		}
		return nums;
	}

}
