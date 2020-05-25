package 二叉排序树;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[] {7,3,10,12,5,1,9};
		//创建一颗二叉排序树
		BinarySortTree bst = new BinarySortTree();
		//循环添加
		for(int i:arr) {
			bst.add(new Node(i));
		}
		bst.midshow();
		System.out.println("======");
		//Node node2 = bst.search(10);
		//Node node =bst.search(15);
		//System.out.println(node2.value);
		//System.out.println(node);
		//Node bss = bst.searchParent(1);
		//System.out.println(bss.value);
//		bst.delete(12);
//		bst.midshow();
//		System.out.println("=======");
//		bst.delete(10);
//		bst.midshow();
		//删除有个子节点的节点
		bst.delete(3);
		bst.midshow();
	}

}
