package ����;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 2, 3, 5};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr, int start, int end) {
        //�������еĵ�0��������Ϊ��׼��
        int partition = arr[start];
        int low = start;
        int high = end;
        //ѭ���ұȱ�׼��������ͱȱ�׼��С����
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
        // ����׼���ŵ��м��λ�ã���׼����λ��
        arr[start] = arr[low];
        //�ѱ�׼�����������ڵ�λ�õ�Ԫ��
        arr[low] = partition;
        //�������е�С������
        if (start < low - 1) quicksort(arr, start, low - 1);
        //�������еĴ�����
        if (low + 1 < end) quicksort(arr, low + 1, end);
    }

}
