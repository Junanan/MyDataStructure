package AVL������;

public class BinarySortTree {
	Node root;
	
	public void add(Node node ) {
		//���Ϊһ�ſ���
		if(root==null) {
			root=node;
		}else {
			root.add(node);
		}
		
	}
	 /**
	 * �����������������С��������
	 */
	public  void midshow() {
		 if(root!=null) {
			 root.midshow(root);
		 }
	 }
	/**
	 * �ڵ����
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
	 * ɾ���ڵ�
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) {
			return ;
		}else{
			//�ҵ�����ڵ�
			Node targer = search(value);
		    //���û������ڵ�
			if(targer==null) {
				return;
			}
			//�ҵ����ĸ��ڵ�
			Node parent = searchParent(value);
			//���ɾ������Ҷ�ӽڵ�
			if(targer.left==null&&targer.right==null) {
				//���ֱ��targer = null;��
				//Ҫɾ��������ڵ�
				if(parent.left.value==value) {
					parent.left=null;
				}
				if(parent.right.value==value) {
					parent.right=null;
				}
				//ɾ���ڵ��������ӽڵ�(ǰ�����ߺ���滻ɾ���ڵ�)
			}else if(targer.left!=null&&targer.right!=null) {
				//ɾ������������С�Ľڵ㣬��ȡ���ýڵ��ֵ
				int min = deletemin(targer.right);
				//�滻Ŀ��ڵ��е�ֵ
				targer.value=min;
			
				//ɾ���ڵ���һ���ӽڵ�
			}else {
				//�����ӽڵ�
				if(targer.left!=null) {
				if(parent.left.value==value) {
					parent.left=targer.left;
				}
				else {
					parent.right=targer.left;
				}
				//�����ӽڵ�
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
	 * ɾ������������С�Ľڵ㣬��ȡ����ֵ
	 * @param right
	 * @return
	 */
	private int deletemin(Node node) {
		Node target = node;
		//�ݹ�������
		while(target.left!=null) {
			target = target.left;
		}
		//ɾ����С������ڵ�
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
