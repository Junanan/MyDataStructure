package 二分法查找;

import java.util.Arrays;

public class 二分法 {
	/**
	 * 测试二分法查找 二分法适用于已经排好序的数组
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
			int low = 0;/////指针1
			int high = arr.length - 1;//////指针2
			while (low <= high) {  // 有= 终止条件为  left =right+1 区间为（right+1，right）区间为空 如果没有= 则是 left =right（right，right） 是非空区间
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
			return -1;// 没有找到返回-1
		}
	}
}
