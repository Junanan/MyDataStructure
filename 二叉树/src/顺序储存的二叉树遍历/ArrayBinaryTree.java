package ˳�򴢴�Ķ���������;

public class ArrayBinaryTree {
	int[] data;
	public ArrayBinaryTree(int[] data) {
		this.data=data;
	}
	public void frontshow() {
		frontshow(0);
	}

	//ǰ�����
	public void frontshow(int index) {
		if(data==null||data.length==0) {
			return;
		}
		//�ȱ�����ǰ����
		System.out.println(data[index]);
		//����������
		if(index*2+1<data.length) {
			frontshow(index*2+1);
		}
		//����������
		if(index*2+2<data.length) {
			frontshow(index*2+2);
		}
		
	}
}
