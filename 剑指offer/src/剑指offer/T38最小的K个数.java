package 剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//示例 1：
//输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//示例 2：
//
//输入：arr = [0,1,2,1], k = 1
//输出：[0]
public class T38最小的K个数 {
	public static int[] getLeastNumberss(int[] arr, int k) {
		if (k == 0)
			return new int[0];
		else if (arr.length < k)
			return arr;
		// 原地不断划分数组
		partitionArray(arr, 0, arr.length - 1, k);
	    // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
		int[] res = new int[k];
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < k; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	 static void partitionArray(int[] arr, int low, int hight, int k) {
		// 做一次 partition 操作
		int m = partition(arr, low, hight);
		// 此时数组前 m 个数，就是最小的 m 个数
		if (k == m)
			// 正好找到最小的 k(m) 个数
			return;
		else if (k < m)
			// 最小的 k 个数一定在前 m 个数中，递归划分
			partitionArray(arr, low, m-1, k);
		else
			// 在右侧数组中寻找最小的 k-m 个数
			partitionArray(arr, m + 1, hight, k);
	}
	// partition 函数和快速排序中相同
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
//	// 默认小顶堆 ((v1,v2)->v2-v1) 改成大顶堆
//	if (k == 0)
//		return new int[0];
//	Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
//	for (int i : arr) {
//		if (heap.isEmpty() || heap.size() < k || heap.peek() > i) {
//			heap.offer(i);
//		}
//		if (heap.size() > k) {// 删除大顶堆
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
