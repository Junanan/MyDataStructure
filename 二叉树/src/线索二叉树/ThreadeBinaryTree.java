package 线索二叉树;

public class ThreadeBinaryTree {
	Threadenode root;
	//用于临时储存前驱节点
	Threadenode pre = null;
	
	public void setRoot(Threadenode root) {
		this.root = root;
	}
	//中序线索化二叉树 递归
	public void threadnodes() {
		threadnodes(root);
	}
	public void threadnodes(Threadenode node) {
		//当前节点为null，直接返回
		if(node==null) {
			return;
		}
		//处理左子树
		threadnodes(node.leftNode);
		//处理前驱节点
		if(node.leftNode==null) {
			//让当前节点的左指针指向前驱节点
		       node.leftNode= pre;
		       //改变当前节点左指针的类型
		       node.leftType=1;
		}
		//处理前驱的右指针，如果前驱节点的右指针是null（没有指下右子树）
		if(pre!=null&&pre.rightNode==null) {
			//让前驱节点的右指针指向当前节点
			pre.rightNode=node;
			pre.rightType=1;
			
		}
		//每处理一个节点，当前节点是下一个节点的前驱节点
		pre=node;
		//处理右子树
		threadnodes(node.rightNode);
	}
	public Threadenode getRoot() {
		return root;
	}

	public void frontShow() {
		if(root!=null)
		root.frontShow();
	}

	public void midShow() {
		if(root!=null)
		root.midShow();
		
	}

	public void backShow() {
		if(root!=null)
		root.backShow();
		
	}
	public Threadenode frontsearch(int i) {
		return root.frontsearch(i);
	}

	public void delete(int i) {
		if(root.value==i) {
			root=null;
		}else {
			root.delete(i);
		}
		
	}


		

}
