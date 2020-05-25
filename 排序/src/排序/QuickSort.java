package ����;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int [] arr = new int[] {4,6,2,3,5};
		quicksort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quicksort(int[] arr, int start, int end) {
		if(start>=end) return ;
			//�������еĵ�0��������Ϊ��׼��
			int stard = arr[start];
			//��¼��Ҫ������±�
			int low = start;
			int high = end ;
			//ѭ���ұȱ�׼��������ͱȱ�׼��С����
			while(low<high) {
				//�ڱ����ƶ����ܸı�˳��  
				while(low<high&&stard<=arr[high]) {
					high--;
				}
				while(low<high&&arr[low]<=stard) {
					low++;
				}
				
			 // �����ѭ��������ʾ�ҵ���λ�û���(low>=high)�ˣ������������������е�λ��
			            int tmp = arr[low];
			             arr[low] = arr[high];
			            arr[high] = tmp;
			     
			}
			    // ����׼���ŵ��м��λ�ã���׼����λ��
			    arr[start] = arr[low];
			  //�ѱ�׼�����������ڵ�λ�õ�Ԫ��
			     arr[low] = stard;
			//�������е�С������
			quicksort(arr, start, low-1);
			//�������еĴ�����
			quicksort(arr, low+1, end);
		
		
		
	}

}
