package ����������;

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
		//�жϴ���ڵ�����ڵ�Ĵ�С
		//���С
		if(node.value<this.value) {
			//�����ڵ�Ϊ��
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
	 * �����������������
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
