package �ݹ�;
//����124�������е����·����
//����һ�����������ҵ����·�������·���е�ÿ���ڵ������ֵͬ�� ����·�����Ծ���Ҳ���Բ��������ڵ㡣
//
//ע�⣺�����ڵ�֮���·������������֮��ı�����ʾ��
public class L687�ֵͬ·�� {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
//    �� arrow_length(node) Ϊ�ӽڵ� node ����������ͷ�ĳ��ȡ���� node.Left ��������ڵ� node ������ͬ��ֵ�����ֵ�ͻ��� 1 + arrow_length(node.left)���� node.right ���ڵ������Ҳ��һ����
//    �����Ǽ����ͷ����ʱ����ѡ�𰸽��Ǹýڵ������������ϵļ�ͷ֮�͡����ǽ���Щ��ѡ�𰸼�¼��������������Ѵ𰸡�
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
	    public static void main(String[] args) {
	    	TreeNode root = new TreeNode(5);
	    	TreeNode n2 = new TreeNode(4);
	    	TreeNode n7 = new TreeNode(5);
	    	TreeNode n1 = new TreeNode(1);
	    	TreeNode n3 = new TreeNode(1);
	    	TreeNode n9 = new TreeNode(5);
	    	root.left =n2;
	    	root.right = n7;
	    	n2.left =n1;
	    	n2.right =n3;
	    	n7.right = n9;
//	    	System.out.println(longestUnivaluePath(root));
		}
}
