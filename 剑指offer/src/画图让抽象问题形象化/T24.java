package ��ͼ�ó�����������;

//�����һ������������һ�����������ú���������ľ���
//
//�������룺
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//���������
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
public class T24 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null) return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTree(root.left);
		mirrorTree(root.right);
	return root;
    }

}
