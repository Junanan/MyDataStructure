package ����;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr =new int[] {2,3,7,9,1,0,5,6,8};
		System.out.println(Arrays.toString(arr));
		shellsort(arr);
		System.out.println(Arrays.toString(arr));
		//System.out.println(arr.length);
	}
	private static void shellsort(int[] arr) {
		// �������в���
		for (int d = arr.length / 2; d > 0; d /= 2) {
			// ��������Ԫ��
			for (int i = d; i < arr.length; i++) {
				// ��������������Ԫ��
				for (int j = i - d; j >= 0; j -= d) {
					// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ��
					if (arr[j] > arr[j + d]) {
						int temp = arr[j];
						arr[j] = arr[j + d];
						arr[j + d] = temp;
					}
				}
			}
//			System.out.println("��"+k+"����������"+Arrays.toString(arr));
//			k++;

		}
	}
}
