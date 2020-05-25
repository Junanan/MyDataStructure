package AVL二叉树;

public class BinarySortTree {
	Node root;
	
	public void add(Node node ) {
		//如果为一颗空树
		if(root==null) {
			root=node;
		}else {
			root.add(node);
		}
		
	}
	 /**
	 * 中序遍历二叉树，从小到大排序
	 */
	public  void midshow() {
		 if(root!=null) {
			 root.midshow(root);
		 }
	 }
	/**
	 * 节点查找
	 * @param value
	 * @return
	 */
	public Node search(int value) {
		if(root==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	/**
	 * 删除节点
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) {
			return ;
		}else{
			//找到这个节点
			Node targer = search(value);
		    //如果没有这个节点
			if(targer==null) {
				return;
			}
			//找到他的父节点
			Node parent = searchParent(value);
			//如果删除的是叶子节点
			if(targer.left==null&&targer.right==null) {
				//如果直接targer = null;？
				//要删除的是左节点
				if(parent.left.value==value) {
					parent.left=null;
				}
				if(parent.right.value==value) {
					parent.right=null;
				}
				//删除节点有两个子节点(前驱或者后继替换删除节点)
			}else if(targer.left!=null&&targer.right!=null) {
				//删除右子树中最小的节点，获取到该节点的值
				int min = deletemin(targer.right);
				//替换目标节点中的值
				targer.value=min;
			
				//删除节点有一个子节点
			}else {
				//有左子节点
				if(targer.left!=null) {
				if(parent.left.value==value) {
					parent.left=targer.left;
				}
				else {
					parent.right=targer.left;
				}
				//有右子节点
			}else {
				if(targer.right!=null) {
					if(parent.right.value==value) {
						parent.right=targer.right;
					}else {
						parent.left=targer.right;
					}
				}
			}
				
			}	
		}
	}
	/**
	 * 删除右子树中最小的节点，并取到其值
	 * @param right
	 * @return
	 */
	private int deletemin(Node node) {
		Node target = node;
		//递归向左找
		while(target.left!=null) {
			target = target.left;
		}
		//删除最小的这个节点
		delete(target.value);
		return target.value;
	}
	public Node searchParent(int value) {
		if(root==null) {
			return null;
		}
	     return root.searchParent(value);
	}

}
