package 剑指offer;
//给定一棵二叉搜索树，请找出其中第k大的节点。
//示例 1:
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4
//示例 2:
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4
public class T51 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	/////////Review 分割线
	
	 static int res;
	 static int count;
	public static int kthLargest(TreeNode root, int k) {
		count = k;   ///必须要用全局变量  否则在递归的K会重复使用 
		dfs(root);
		return res;
    }
	private static void dfs(TreeNode root) {
		if(root==null) return ;
		dfs(root.right);
		if(count==0) return;//找到后提前退出
		count--;
		res = root.val; ;
		dfs(root.left);
	} 
//使用中序遍历的倒序遍历
	public static void main(String[] args) {
		TreeNode root =  new TreeNode(5);
		TreeNode n1 =  new TreeNode(6);
		TreeNode n2 =  new TreeNode(3);
		TreeNode n3 =  new TreeNode(2);
		TreeNode n4 =  new TreeNode(4);
		root.right = n1;
		root.left = n2;
		n2.right = n4;
		n2.left = n3;
		System.out.println(kthLargest(root,3));
	}
}
