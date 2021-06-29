package ����;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2};
        System.out.println(Arrays.toString(arr));
        mergesort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        Random random = new Random();
        int i = random.nextInt(5);
        System.out.println(i);
    }

    public static void mergesort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            mergesort(arr, low, middle);
            mergesort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }

    }

    public static void merge(int[] arr, int low, int middle, int high) {
        //���ڴ���鲢�����ʱ����
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        //���ڼ�¼����ʱ�����д�ŵ��±�
        int index = 0;
        //������������ȡ��С�����֣�������ʱ������
        while (i <= middle && j <= high) {
            //��һ����������ݸ�С
            if (arr[i] <= arr[j]) {
                //��С�����ݷ�����ʱ������
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        //������������
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        while (i <= middle) {
            temp[index++] = arr[i++];
        }
        //����ʱ�����е��������´���ԭ����
		if (temp.length >= 0) {
			System.arraycopy(temp, 0, arr, low, temp.length);
		}
//          index = 0;
//        while(left <= right){
//            arr[left++] = temp[t++];
//        }
    }

}
