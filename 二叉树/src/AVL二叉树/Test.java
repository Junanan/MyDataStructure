package AVL二叉树;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
	//	int[] arr = new int[] {8,9,6,7,5,4};
		int[] arr = new int[] {2,1,4,3,5,6};
		//创建一颗二叉排序树
		BinarySortTree bst = new BinarySortTree();
		//循环添加
		for(int i:arr) {
			bst.add(new Node(i));
		}//左旋转有问题
		//查看高度
		System.out.println(bst.root.height());
		//查看根节点（如果没有右旋转为8）
		System.out.println(bst.root.value);
	}

}
