package ����;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		//����һ������
	    int[] arr1 = new int[] {7,8,9};
	    //��ȡ���鳤��
	    int length1 = arr1.length;
	    System.out.println("arr1�ĳ���"+arr1.length);
	    //���������е�Ԫ�أ�������[�±�] ע���±��0��ʼ��������ȡ������-1
	    int elemengt0 = arr1[0];
	    //Ҫ���������Ŀ��Ԫ��
	    int dst=6;
	    
	    //���Ԫ��
	    //����һ���µ����飬������ԭ���鳤��+1
	    int[] newarr = new int[arr1.length+1];
	    //��ԭ�����е�����ȫ�����Ƶ���������
	    for(int i=0;i<arr1.length;i++) {
	    	newarr[i]=arr1[i];
	    }
	    //��Ŀ��Ԫ�ط�������������
	    newarr[newarr.length-1]=dst;
	    //�������滻ԭ����
	    arr1=newarr;
	    System.out.println(Arrays.toString(arr1));
	    //ɾ��Ԫ�ص��±�
	    int ds =1;
	    //ɾ��Ԫ��
	    //����һ���µ����飬������ԭ���鳤��-1
	    int[] newArr = new int[arr1.length-1];
	    //����ԭ�����г���Ҫɾ�����Ǹ�Ԫ������������Ԫ��
	    for(int i=0;i<newArr.length;i++) {
	    	if(i<ds) {
	    		newArr[i]=arr1[i];
	    	}else {
	    		newArr[i]=arr1[i+1];
	    	}
	    }
	    arr1=newArr;
	    System.out.println(Arrays.toString(arr1));
	}

}
