package �ݹ�;


//����һ�����������ҳ�����С��ȡ�
//��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
//˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
public class L111����������С��� {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.right==null) return minDepth(root.left)+1;
		else if(root.left==null) return minDepth(root.right)+1;
		else return Math.min(minDepth(root.right), minDepth(root.left))+1;
    }
////�������������  1,2 ���ӹ�����
}
	