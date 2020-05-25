package 排序;

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
		int k=1;
		// 遍历所有步长
		for (int d = arr.length / 2; d > 0; d /= 2) {
			System.out.println("d="+d);
			// 遍历所有元素
			for (int i = d; i < arr.length; i++) {
				System.out.println("i="+i);
				// 遍历本组中所有元素
				for (int j = i - d; j >= 0; j -= d) {
					// 如果当前元素大于加上步长后的那个元素
					System.out.println("j="+j);
					if (arr[j] > arr[j + d]) {
						int temp = arr[j];
						arr[j] = arr[j + d];
						arr[j + d] = temp;
						System.out.println(Arrays.toString(arr));
					}
				}
			}
//			System.out.println("第"+k+"次排序结果："+Arrays.toString(arr));
//			k++;

		}
	}
}
