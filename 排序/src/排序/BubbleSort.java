package 排序;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5,7,2,9,4,1,10,5,7};
		System.out.println(Arrays.toString(arr));
		bubblesort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void bubblesort(int[] arr) {
		//控制轮数
		for(int i=0;i<arr.length-1;i++) {
			//控制数组交换
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j+1]<arr[j]) {
				      int temp =arr[j];
				      arr[j] = arr[j+1];
				      arr[j+1] = temp;
				}
			}
		}
		
	}

}
