package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
	public static double[] BucketSort(double[] array) {
//		区间跨度 = （最大值-最小值）/ （桶的数量 - 1）
		// 1.遍历出最大 最小值 然后算出差值
		double max = array[0];
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		double d = max - min;
		// 2.初始化桶
		int bucketNum = array.length;
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>();
		for (int i = 0; i < bucketNum; i++) {
			bucketList.add(new LinkedList<Double>());
		}

		// 3.遍历原始数组，将每个元素放入桶中
		for (int i = 0; i < array.length; i++) {
			int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
			bucketList.get(num).add(array[i]);
		}
		// 4.对每个桶内部进行排序
		for (int i = 0; i < bucketList.size(); i++) {
			// JDK 底层采用了归并排序或归并的优化版本
			Collections.sort(bucketList.get(i));
		}
		// 5.输出全部元素
		double[] sortedArray = new double[array.length];
		int index = 0;
		for (LinkedList<Double> list : bucketList) {
			for (double element : list) {
				sortedArray[index] = element;
				index++;
			}
		}
		return sortedArray;
	}
	public static void main(String[] args) {
		double[] array = new double[] {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
		double[] sortedArray = BucketSort(array);
		System.out.println(Arrays.toString(sortedArray));
	}
}
