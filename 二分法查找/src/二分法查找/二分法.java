package ���ַ�����;

import java.util.Arrays;

public class ���ַ� {
	/**
	 * ���Զ��ַ����� ���ַ��������Ѿ��ź��������
	 * 
	 * @author Administrator
	 *
	 */
	static class TestBinarySearch {
		public static void main(String[] args) {
			int[] arr = { 30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8 };
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
			System.out.println(myBinarySearch(arr, 40));
		}

		public static int myBinarySearch(int[] arr, int value) {
			int low = 0;/////ָ��1
			int high = arr.length - 1;//////ָ��2
			while (low <= high) {  // ��= ��ֹ����Ϊ  left =right+1 ����Ϊ��right+1��right������Ϊ�� ���û��= ���� left =right��right��right�� �Ƿǿ�����
				int mid = (low + high) / 2;
				if (value == arr[mid]) {
					System.out.println(low);
					System.out.println(high);
					return mid;
				}
				if (value > arr[mid]) {
					low = mid + 1;
				}
				if (value < arr[mid]) {
					high = mid - 1;
				}
			}
			return -1;// û���ҵ�����-1
		}
	}
}
