package 剑指offer;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
//要求不能创建任何新的节点，只能调整树中节点指针的指向。
//有图 
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
		pre =cur;////pre = pre.right pre.right不存在
		dfs(cur.right);
	}
}
