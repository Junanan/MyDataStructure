package ��ָoffer;
//����һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
//���磺
//���������� [3,9,20,null,null,15,7]��
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class T52 {
	 public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		 
	 public int maxDepth(TreeNode root) {
	        if(root==null) return 0;
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        return Math.max(left, right)+1;
	    }
}
