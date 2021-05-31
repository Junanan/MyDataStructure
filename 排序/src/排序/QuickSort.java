package 排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 2, 3, 5};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr, int start, int end) {
        //把数组中的第0个数字作为标准数
        int partition = arr[start];
        int low = start;
        int high = end;
        //循环找比标准数大的数和比标准数小的数
        while (low < high) {
            while (low < high && partition <= arr[high]) {
                high--;
            }
            while (low < high && arr[low] <= partition) {
                low++;
            }
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        }
        // 将基准数放到中间的位置（基准数归位）
        arr[start] = arr[low];
        //把标准数赋给低所在的位置的元素
        arr[low] = partition;
        //处理所有的小的数字
        if (start < low - 1) quicksort(arr, start, low - 1);
        //处理所有的大数字
        if (low + 1 < end) quicksort(arr, low + 1, end);
    }

}
