package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
	public static double[] BucketSort(double[] array) {
//		������ = �����ֵ-��Сֵ��/ ��Ͱ������ - 1��
		// 1.��������� ��Сֵ Ȼ�������ֵ
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
		// 2.��ʼ��Ͱ
		int bucketNum = array.length;
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>();
		for (int i = 0; i < bucketNum; i++) {
			bucketList.add(new LinkedList<Double>());
		}

		// 3.����ԭʼ���飬��ÿ��Ԫ�ط���Ͱ��
		for (int i = 0; i < array.length; i++) {
			int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
			bucketList.get(num).add(array[i]);
		}
		// 4.��ÿ��Ͱ�ڲ���������
		for (int i = 0; i < bucketList.size(); i++) {
			// JDK �ײ�����˹鲢�����鲢���Ż��汾
			Collections.sort(bucketList.get(i));
		}
		// 5.���ȫ��Ԫ��
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
