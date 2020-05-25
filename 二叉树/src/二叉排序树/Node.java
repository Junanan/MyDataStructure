package 二叉排序树;

public class Node {
	int value;
	Node left;
	Node right;
	public Node (int value) {
		this.value = value;
	}
	public void add(Node node) {
		if(node==null) {
			return;
		}
		//判断传入节点与根节点的大小
		//如果小
		if(node.value<this.value) {
			//如果左节点为空
			if(this.left==null) {
				this.left=node;
			}else {
				this.left.add(node);
			}
		}else {
			if(node.value>this.value) {
				if(this.right==null) {
					this.right=node;
				}else {
					this.right.add(node);
				}
			}
		}
	}
	/**
	 * 中序遍历二叉排序树
	 * @param node
	 */
	public void midshow(Node node) {
		if(node==null) {
			return;		
		}
		if(node.left!=null){
		midshow(node.left);
		}
		System.out.println(node.value);
		if(node.right!=null) {
		midshow(node.right);
		}
	}
	public Node search(int value) {
		if(value==this.value) {
			return this;
		}else if(this.value>value) {
			if(left==null) {
				return null;
			}
				return left.search(value);				
			}else {
				if(right==null) {
					return null;
				}
				return right.search(value);
			}
	}
	public Node searchParent(int value) {
		if(this.left!=null&&this.left.value==value||this.right!=null&&this.right.value==value) {
			return this;
		}else {
			if(value<this.value&&this.left!=null) {
				return this.left.searchParent(value);
			}else if(value>this.value&&this.right!=null){
				return this.right.searchParent(value);
			}
			return null;
		}
   }
		

}
