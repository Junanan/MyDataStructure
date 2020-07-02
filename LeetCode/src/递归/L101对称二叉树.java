package �ݹ�;

//����һ����������������Ƿ��Ǿ���ԳƵġ�
public class L101�Գƶ����� {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return recus(root.left, root.right);
	}

	private boolean recus(TreeNode L, TreeNode R) {
		if (L == null && R == null)
			return true;
		if (L == null || R == null || L.val != R.val)
			return false;
		return recus(L.left, R.right) && recus(L.right, R.left);
	}
}
