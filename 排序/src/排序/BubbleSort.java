package ����;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 1, 10, 5, 7};
        System.out.println(Arrays.toString(arr));
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubblesort(int[] arr) {
        //��������
        for (int i = 0; i < arr.length - 1; i++) {
            //�������齻��
            for (int j = 0 ; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
    //�Ż�
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        //��¼��¼�������һ��Ԫ�ؽ�����λ��
        int lastExchangeIndex = 0;
        //�������еı߽磬ÿ�αȽ�ֻ��Ҫ�ȵ�����Ϊֹ
        int sortBorder = arr.length-1;
        for (int i = 0; i < arr.length - 1; i++) {
            //�Ƿ��Ѿ�����ı�ǣ�Ĭ������
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                //��������>,��������<
                if (arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    //����Ԫ�ؽ�����������������״̬
                    isSorted = false;
                    //����Ϊ���һ�ν���Ԫ�ص�λ��
                    lastExchangeIndex = j;
                }
            }
            //�����������еı߽�
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }
}
