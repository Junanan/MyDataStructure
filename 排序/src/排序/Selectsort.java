package 排序;

import java.util.Arrays;

public class Selectsort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,5,8,14,23,54,2};
		selectsort(arr);
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectsort(int[] arr) {
		for(int i =0;i<arr.length-1;i++) {
			int minindex = i ;
			//把当前遍历的数和后面所有的数依次比较，并记录下最小的数的下标
			for(int j=i+1;j<arr.length;j++) {
				//如果后面比较的数比记录的最小的数小
				if(arr[minindex]>arr[j]) {
					//记录最小的那个数的下标
					minindex=j;
					//System.out.println("minindex="+minindex);
				}
			}
			//System.out.println(Arrays.toString(arr));
			//如果最小的数和当前遍历数的下标不一致
			if(i!=minindex) {
				int temp=arr[i];
				arr[i]=arr[minindex];
				arr[minindex]=temp;
				//System.out.println(Arrays.toString(arr));
			}
		}
	}

}
