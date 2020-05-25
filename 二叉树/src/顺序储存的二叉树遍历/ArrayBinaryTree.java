package 顺序储存的二叉树遍历;

public class ArrayBinaryTree {
	int[] data;
	public ArrayBinaryTree(int[] data) {
		this.data=data;
	}
	public void frontshow() {
		frontshow(0);
	}

	//前序遍历
	public void frontshow(int index) {
		if(data==null||data.length==0) {
			return;
		}
		//先遍历当前内容
		System.out.println(data[index]);
		//处理左子树
		if(index*2+1<data.length) {
			frontshow(index*2+1);
		}
		//处理右子树
		if(index*2+2<data.length) {
			frontshow(index*2+2);
		}
		
	}
}
