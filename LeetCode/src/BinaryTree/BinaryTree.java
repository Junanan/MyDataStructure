package BinaryTree;

public class BinaryTree {
	
	TreeNode root;
	//���ø��ڵ�
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode getRoot() {
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

	public TreeNode frontsearch(int i) {
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
