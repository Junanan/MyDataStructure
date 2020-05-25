package 二叉树;

public class TreeNode {
	// 节点的权
	int value;
	// 左儿子
	TreeNode leftNode;
	// 右儿子
	TreeNode rightNode;

	public TreeNode(int value) {
		this.value = value;
	}

	// 设置左儿子
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	// 设置右儿子
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

    //前序遍历
	public void frontShow() {

		System.out.print(value);
		if (leftNode != null) {
			leftNode.frontShow();
		}
		if (rightNode != null) {
			rightNode.frontShow();
		}

	}

	public void midShow() {
		
		if (leftNode != null) {
			leftNode.midShow();
		}
		System.out.print(value);
		if (rightNode != null) {
			rightNode.midShow();
		}
		
	}

	public void backShow() {
		if (leftNode != null) {
			leftNode.backShow();
		}
		if (rightNode != null) {
			rightNode.backShow();
		}
		System.out.print(value);
		
	}

	public TreeNode frontsearch(int i) {
		TreeNode target=null;
		//对比当前节点的值
		if(this.value==i) {
			return this ;
		}else {
			//查找左儿子
			if(leftNode!=null) {
				//有可能可以查到，也可能查不到，查不到target还是null
				target = leftNode.frontsearch(i);
			}
			//如果不为空，说明在左儿子中已经找到
			if(target!=null) {
				return target;
			}
			if(rightNode!=null) {
				target=rightNode.frontsearch(i);
			}
		}
		return target;
	}

	public void delete(int i) {
		TreeNode parent = this;
		//判断左儿子
		if(parent.leftNode!=null&&parent.leftNode.value==i) {
			parent.leftNode=null;
			return;			
		}
		//判断右儿子
		if(parent.rightNode!=null&&parent.rightNode.value==i) {
			parent.rightNode=null;
			return;
		}
		//递归检查并删除左儿子
		parent=leftNode;
		if(parent!=null) { 
			parent.delete(i);
		}
		//递归检查并删除右儿子
		parent=rightNode;
		if(parent!=null) {
			parent.delete(i);
		}
		
	}

}
