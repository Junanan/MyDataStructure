package ����������;

public class Threadenode {
	// �ڵ��Ȩ
	int value;
	// �����
	Threadenode leftNode;
	// �Ҷ���
	Threadenode rightNode;
	public int leftType;
	public int rightType;

	public Threadenode(int value) {
		this.value = value;
	}

	// ���������
	public void setLeftNode(Threadenode leftNode) {
		this.leftNode = leftNode;
	}

	// �����Ҷ���
	public void setRightNode(Threadenode rightNode) {
		this.rightNode = rightNode;
	}

    //ǰ�����
	public void frontShow() {

		System.out.println(value);
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
		System.out.println(value);
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
		System.out.println(value);
		
	}
	public Threadenode frontsearch(int i) {
		Threadenode target=null;
		//�Աȵ�ǰ�ڵ��ֵ
		if(this.value==i) {
			return this ;
		}else {
			//���������
			if(leftNode!=null) {
				//�п��ܿ��Բ鵽��Ҳ���ܲ鲻�����鲻��target����null
				target = leftNode.frontsearch(i);
			}
			//�����Ϊ�գ�˵������������Ѿ��ҵ�
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
		Threadenode parent = this;
		//�ж������
		if(parent.leftNode!=null&&parent.leftNode.value==i) {
			parent.leftNode=null;
			return;			
		}
		//�ж��Ҷ���
		if(parent.rightNode!=null&&parent.rightNode.value==i) {
			parent.rightNode=null;
			return;
		}
		//�ݹ��鲢ɾ�������
		parent=leftNode;
		if(parent!=null) { 
			parent.delete(i);
		}
		//�ݹ��鲢ɾ���Ҷ���
		parent=rightNode;
		if(parent!=null) {
			parent.delete(i);
		}
		
	}

}
