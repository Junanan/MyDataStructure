package 排序;

import java.util.Arrays;

public class CountSort {
	public static int[] CountSort(int[] array) {
		// 1.求出最大值
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		// 2.创建计数数组
		int[] count = new int[max + 1];
		// 3.遍历数组 统计次数
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		int index = 0;
		int[] sortArray = new int[array.length];
		for (int i = 0; i < count.length; i++) {
			// 遍历下标出现的次数
			for (int j = 0; j < count[i]; j++) {
				sortArray[index++] = i;
			}
		}
		return sortArray;
		
		// o(n+m)
	}
	public static void main(String[] args) { 
		int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
		int[] sortedArray = CountSort(array);
		System.out.println(Arrays.toString(sortedArray));
	}
}
