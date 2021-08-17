package 排序;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 1, 10, 5, 7};
        System.out.println(Arrays.toString(arr));
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubblesort(int[] arr) {
        //控制轮数
        for (int i = 0; i < arr.length - 1; i++) {
            //控制数组交换
            for (int j = 0 ; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
    //优化
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        //记录记录下来最后一次元素交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = arr.length-1;
        for (int i = 0; i < arr.length - 1; i++) {
            //是否已经有序的标记，默认有序
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                //升序排序>,降序排序<
                if (arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    //发生元素交换，序列仍是无序状态
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            //更新无序数列的边界
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }
}
