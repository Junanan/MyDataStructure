package ����;

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
			//�ѵ�ǰ���������ͺ������е������αȽϣ�����¼����С�������±�
			for(int j=i+1;j<arr.length;j++) {
				//�������Ƚϵ����ȼ�¼����С����С
				if(arr[minindex]>arr[j]) {
					//��¼��С���Ǹ������±�
					minindex=j;
					//System.out.println("minindex="+minindex);
				}
			}
			//System.out.println(Arrays.toString(arr));
			//�����С�����͵�ǰ���������±겻һ��
			if(i!=minindex) {
				int temp=arr[i];
				arr[i]=arr[minindex];
				arr[minindex]=temp;
				//System.out.println(Arrays.toString(arr));
			}
		}
	}

}
