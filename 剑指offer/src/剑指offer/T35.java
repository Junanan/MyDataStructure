package ��ָoffer;

//����һ�ö��������������ö���������ת����һ�������ѭ��˫������
//Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
//��ͼ 
public class T35 {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node() {
		}
		public Node(int _val) {
			val = _val;
		}
		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
	Node head = new Node(0),pre = head;
	public Node treeToDoublyList(Node root) {
		if(root==null) return null;
		dfs(root);
		head = head.right;
		head.left = pre;
		pre.right =head;
		return head;
	}
	private void dfs(Node cur) {
		if(cur==null) return ;
		dfs(cur.left);
		pre.right = cur;
		cur.left = pre;
		pre =cur;////pre = pre.right pre.right������
		dfs(cur.right);
	}
}
