package AVL������;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
	//	int[] arr = new int[] {8,9,6,7,5,4};
		int[] arr = new int[] {2,1,4,3,5,6};
		//����һ�Ŷ���������
		BinarySortTree bst = new BinarySortTree();
		//ѭ�����
		for(int i:arr) {
			bst.add(new Node(i));
		}//����ת������
		//�鿴�߶�
		System.out.println(bst.root.height());
		//�鿴���ڵ㣨���û������תΪ8��
		System.out.println(bst.root.value);
	}

}
