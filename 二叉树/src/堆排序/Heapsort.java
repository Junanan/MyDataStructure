package 堆排序;

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
		//开始位置是最后一个非叶子节点，即最后一个节点的父节点,这个节点之后的节点无叶子节点但这样无法的得到最大堆
		int start = (ary.length-1)/2;///最后一个非叶子节点下标
		//调整为大顶堆
		for(int  i=start;i>=0;i--) {
			maxheap(ary,ary.length,i);
		}
		//先把数组中的第0个和堆中的最后一个数交换位置，再把前面的处理为大顶堆
		for(int i=ary.length-1;i>0;i--) {
			int temp = ary[0];
			ary[0]=ary[i];
			ary[i]=temp;
			maxheap(ary,i,0);
		}
		
	}

	public static void maxheap(int[] ary,int size,int index) {
			//左子节点的在数组中的下标
			int leftnode = 2*index+1;	
			//右子节点
			int rightnode = 2*index+2;
			int max =index;
			//和两个子节点分别对比，找出最大的节点
			if(leftnode<size&&ary[leftnode]>ary[max]) {
				max=leftnode;
			}
			if(rightnode<size&&ary[rightnode]>ary[max]) {
			max=rightnode;
		}
		//交换位置
			if(max!=index) {
				int temp = ary[index];
						ary[index]=ary[max];
						ary[max] = temp;
		//可能交换位置会破坏堆位置，之前的需要重新调整
						maxheap(ary,size,max);
			}
	}	
}
