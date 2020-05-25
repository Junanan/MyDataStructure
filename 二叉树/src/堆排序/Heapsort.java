package ������;

import java.util.Arrays;

public class Heapsort {
	public static void main(String[] args) {
		int[] ary = new int[] {9,6,8,7,0,1,10,4,2};
		heapsort(ary);
		for(int i=0;i<ary.length;i++)
		System.out.println(ary[i]);
		System.out.println("========");
		System.out.println(Arrays.toString(ary));
	}
	public static void heapsort(int[] ary) {
		//��ʼλ�������һ����Ҷ�ӽڵ㣬�����һ���ڵ�ĸ��ڵ�,����ڵ�֮��Ľڵ���Ҷ�ӽڵ㵫�����޷��ĵõ�����
		int start = (ary.length-1)/2;///���һ����Ҷ�ӽڵ��±�
		//����Ϊ�󶥶�
		for(int  i=start;i>=0;i--) {
			maxheap(ary,ary.length,i);
		}
		//�Ȱ������еĵ�0���Ͷ��е����һ��������λ�ã��ٰ�ǰ��Ĵ���Ϊ�󶥶�
		for(int i=ary.length-1;i>0;i--) {
			int temp = ary[0];
			ary[0]=ary[i];
			ary[i]=temp;
			maxheap(ary,i,0);
		}
		
	}

	public static void maxheap(int[] ary,int size,int index) {
			//���ӽڵ���������е��±�
			int leftnode = 2*index+1;	
			//���ӽڵ�
			int rightnode = 2*index+2;
			int max =index;
			//�������ӽڵ�ֱ�Աȣ��ҳ����Ľڵ�
			if(leftnode<size&&ary[leftnode]>ary[max]) {
				max=leftnode;
			}
			if(rightnode<size&&ary[rightnode]>ary[max]) {
			max=rightnode;
		}
		//����λ��
			if(max!=index) {
				int temp = ary[index];
						ary[index]=ary[max];
						ary[max] = temp;
		//���ܽ���λ�û��ƻ���λ�ã�֮ǰ����Ҫ���µ���
						maxheap(ary,size,max);
			}
	}	
}
