package ����;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int [] arr = new int[] {5,6,3,4};
		insersort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insersort(int[] arr) {
      //�������е�����
		int j ;
		for(int i=1;i<arr.length;i++) {
			//�����ǰ���ֱ�ǰһ������С
			if(arr[i]<arr[i-1]) {
				//�ѵ�ǰ�������ִ�����
				int temp = arr[i];
				//������ǰ����ǰ�����е�����
				for(j=i-1;j>=0&&temp<arr[j]	;j--){
					//��ǰһ�����ָ�����һ������
					arr[j+1] = arr[j];
				}
				//����ʱ���������forѭ���ĵ�ǰԪ�أ����������������ĺ�һ��Ԫ��
				arr[j+1] = temp;
			}
		}
	}

}
