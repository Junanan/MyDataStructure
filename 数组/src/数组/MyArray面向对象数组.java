package ����;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class MyArray����������� {
	private int[] elements;// Ŀ���������ڴ洢���ݵ�����

	public MyArray�����������() {
		elements = new int[0];
	}

	// ��ȡ���鳤�ȵķ���
	public int size() {
		return elements.length;
	}

	// �������ĩβ���һ��Ԫ��
	public void add(int element) {
		// ����һ��������
		int[] newarr = new int[elements.length + 1];
		// ��ԭ�����е�Ԫ�ظ��Ƶ���������
		for (int i = 0; i < elements.length; i++) {
			newarr[i] = elements[i];
		}
		newarr[elements.length] = element;
		elements = newarr;
		// ��ӡ����Ԫ�ص�����̨

	}

	public void show() {
		System.out.println(Arrays.toString(elements));
	}

	// ɾ�������е�Ԫ��
	public void delete(int index) {
		// �ж��Ƿ�Խ��
		if (index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��");
		}
		// ����һ���µ����飬����Ϊԭ����ĳ���-1
		int[] newarr = new int[elements.length - 1];
		for (int i = 0; i < newarr.length; i++) {
			if (i < index) {
				newarr[i] = elements[i];
			} else {
				newarr[i] = elements[i + 1];
			}
		}
		elements = newarr;
	}

	public void deleteaim(int index) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == index) {
				int j = i;
				int[] newarr = new int[elements.length - 1];
				for (int s = 0; s < newarr.length; s++) {
					if (s < j) {
						newarr[s] = elements[s];
					} else {
						newarr[s] = elements[s + 1];
					}
				}
				elements = newarr;
			}
//			}else(elements[i]!=index){
//				System.out.println("�����ڴ���");
//			}
		}
	}
	//����һ��Ԫ�ص�ָ��λ��
	public void insert(int index,int element) {
		int[] newarr= new int[elements.length+1];
		for(int i=0;i<elements.length;i++) {
			if(i<index) {
				newarr[i]=elements[i];
			}else {
				newarr[i+1]=elements[i];
			}
		}
				newarr[index]=element;
				elements=newarr;
	}
	//�滻ָ��Ԫ��
	public void set(int index,int element) {
		// �ж��Ƿ�Խ��
				if (index < 0 || index > elements.length - 1) {
					throw new RuntimeException("�±�Խ��");
				}
		elements[index]=element;
	}

}
