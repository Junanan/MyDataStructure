package 递归;
//类似124二叉树中的最大路径和
//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
//注意：两个节点之间的路径长度由它们之间的边数表示。
public class L687最长同值路径 {
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
//    令 arrow_length(node) 为从节点 node 延伸出的最长箭头的长度。如果 node.Left 存在且与节点 node 具有相同的值，则该值就会是 1 + arrow_length(node.left)。在 node.right 存在的情况下也是一样。
//    当我们计算箭头长度时，候选答案将是该节点在两个方向上的箭头之和。我们将这些候选答案记录下来，并返回最佳答案。
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
