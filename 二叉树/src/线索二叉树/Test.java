package ����������;
public class Test {
	public static void main(String[] args) {
	//����һ����
		ThreadeBinaryTree ThreadeBinaryTree = new ThreadeBinaryTree();
	//����һ�����ڵ�
	Threadenode root = new Threadenode(1);
	//�Ѹ��ڵ㸳����
	ThreadeBinaryTree.setRoot(root);
	//�����ҽڵ�
	Threadenode rootr = new Threadenode(3);
	//������ڵ�
	Threadenode rootl = new Threadenode(2);
	//����Ϊ���ڵ����ڵ�
	root.setLeftNode(rootl);
	//����Ϊ���ڵ���ҽڵ�
	root.setRightNode(rootr);
	//Ϊ�ڶ������ڵ㴴�������ӽڵ�
	rootl.setLeftNode(new Threadenode(4));
	Threadenode fivenode = new Threadenode(5);
	rootl.setLeftNode(fivenode);
	//Ϊ�ڶ����ҽڵ㴴�������ӽڵ�
	rootr.setLeftNode(new Threadenode(6));
	rootr.setRightNode(new Threadenode(7));
	//ǰ�����
	ThreadeBinaryTree.frontShow();
	System.out.println("===========");
	//�������
	ThreadeBinaryTree.midShow();
	System.out.println("===========");
	//�������
	ThreadeBinaryTree.backShow();
	//ǰ�����
	Threadenode result = ThreadeBinaryTree.frontsearch(3);
	System.out.println(result);
	//�ڵ�ɾ��
	System.out.println("===========");
	//ThreadeBinaryTree.delete(3);
	ThreadeBinaryTree.frontShow();
	//��������������
	ThreadeBinaryTree.threadnodes();
	//��ȡ5�ڵ�ĺ�̽ڵ�
	Threadenode afterFive = fivenode.rightNode;
	System.out.println(afterFive.value);
	}
}
