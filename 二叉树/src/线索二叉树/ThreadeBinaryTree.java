package ����������;

public class ThreadeBinaryTree {
	Threadenode root;
	//������ʱ����ǰ���ڵ�
	Threadenode pre = null;
	
	public void setRoot(Threadenode root) {
		this.root = root;
	}
	//���������������� �ݹ�
	public void threadnodes() {
		threadnodes(root);
	}
	public void threadnodes(Threadenode node) {
		//��ǰ�ڵ�Ϊnull��ֱ�ӷ���
		if(node==null) {
			return;
		}
		//����������
		threadnodes(node.leftNode);
		//����ǰ���ڵ�
		if(node.leftNode==null) {
			//�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
		       node.leftNode= pre;
		       //�ı䵱ǰ�ڵ���ָ�������
		       node.leftType=1;
		}
		//����ǰ������ָ�룬���ǰ���ڵ����ָ����null��û��ָ����������
		if(pre!=null&&pre.rightNode==null) {
			//��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			pre.rightNode=node;
			pre.rightType=1;
			
		}
		//ÿ����һ���ڵ㣬��ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
		pre=node;
		//����������
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
