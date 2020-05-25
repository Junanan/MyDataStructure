package BinaryTree;

public class TestBinaryTree {
	public static void main(String[] args) {
		//����һ����
		BinaryTree binTree = new BinaryTree();
		//����һ�����ڵ�
		TreeNode root = new TreeNode(1);
		//�Ѹ��ڵ㸳����
		binTree.setRoot(root);
		//�����ҽڵ�
		TreeNode rootr = new TreeNode(3);
		//������ڵ�
		TreeNode rootl = new TreeNode(2);
		//����Ϊ���ڵ����ڵ�
		root.setLeftNode(rootl);
		//����Ϊ���ڵ���ҽڵ�
		root.setRightNode(rootr);
		//Ϊ�ڶ������ڵ㴴�������ӽڵ�
		rootl.setLeftNode(new TreeNode(4));
		rootl.setRightNode(new TreeNode(5));
		//Ϊ�ڶ����ҽڵ㴴�������ӽڵ�
		rootr.setLeftNode(new TreeNode(6));
		rootr.setRightNode(new TreeNode(7));
		//ǰ�����
		binTree.frontShow();
		System.out.print("===========");
		//�������
		binTree.midShow();
		System.out.println("===========");
		//�������
		binTree.backShow();
		//ǰ�����
		TreeNode result = binTree.frontsearch(3);
		System.out.println(result);
		//�ڵ�ɾ��
		System.out.println("===========");
		binTree.delete(2);
		binTree.frontShow();


	}
}
