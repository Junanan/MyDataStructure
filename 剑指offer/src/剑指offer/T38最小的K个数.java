package ��ָoffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//������������ arr ���ҳ�������С�� k ���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
//
//ʾ�� 1��
//���룺arr = [3,2,1], k = 2
//�����[1,2] ���� [2,1]
//ʾ�� 2��
//
//���룺arr = [0,1,2,1], k = 1
//�����[0]
public class T38��С��K���� {
	public static int[] getLeastNumberss(int[] arr, int k) {
		if (k == 0)
			return new int[0];
		else if (arr.length < k)
			return arr;
		// ԭ�ز��ϻ�������
		partitionArray(arr, 0, arr.length - 1, k);
	    // �����ǰ k ������ʱ������С�� k ���������������
		int[] res = new int[k];
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < k; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	 static void partitionArray(int[] arr, int low, int hight, int k) {
		// ��һ�� partition ����
		int m = partition(arr, low, hight);
		// ��ʱ����ǰ m ������������С�� m ����
		if (k == m)
			// �����ҵ���С�� k(m) ����
			return;
		else if (k < m)
			// ��С�� k ����һ����ǰ m �����У��ݹ黮��
			partitionArray(arr, low, m-1, k);
		else
			// ���Ҳ�������Ѱ����С�� k-m ����
			partitionArray(arr, m + 1, hight, k);
	}
	// partition �����Ϳ�����������ͬ
	 static int partition(int[] arr, int low, int hight) {
		if(low>=hight) return 0;
		int stard = arr[low];
		int i = low;
		int j = hight;
		while (i < j) {
			while (i < j && arr[j] >= stard) {
				j--;
			}
			while (i < j && arr[i] <= stard) {
				i++;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}	
		arr[low] = arr[i];
		arr[i] = stard;
		return i;
	}
//	public static int[] getLeastNumbers(int[] arr, int k) {
//	// Ĭ��С���� ((v1,v2)->v2-v1) �ĳɴ󶥶�
//	if (k == 0)
//		return new int[0];
//	Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
//	for (int i : arr) {
//		if (heap.isEmpty() || heap.size() < k || heap.peek() > i) {
//			heap.offer(i);
//		}
//		if (heap.size() > k) {// ɾ���󶥶�
//			heap.poll();
//		}
//	}
//	int j = 0;
//	int[] res = new int[] { heap.size() };
//	for (int a : heap) {
//		res[j++] = a;
//	}
//	return res;
//}


	public static void main(String[] args) {
		int[] a = new int[] { 7, 2, 1, 4, 6,5, 3, 8 };
		System.out.println(Arrays.toString(getLeastNumberss(a, 3)));
	}
}
