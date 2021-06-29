package 排序;

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
        //用于储存归并后的临时数组
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        //用于记录在临时数组中存放的下标
        int index = 0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i <= middle && j <= high) {
            //第一个数组的数据更小
            if (arr[i] <= arr[j]) {
                //把小的数据放入临时数组中
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        //处理多余的数据
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        while (i <= middle) {
            temp[index++] = arr[i++];
        }
        //把临时数组中的数据重新存入原数组
		if (temp.length >= 0) {
			System.arraycopy(temp, 0, arr, low, temp.length);
		}
//          index = 0;
//        while(left <= right){
//            arr[left++] = temp[t++];
//        }
    }

}
