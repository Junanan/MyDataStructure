package Daily;

//输入: [1,2,3]
//	    1
//	   / \
//	  2   3
//	输出: 25
//	解释:
//	从根到叶子节点路径 1->2 代表数字 12.
//	从根到叶子节点路径 1->3 代表数字 13.
//	因此，数字总和 = 12 + 13 = 25.
//	示例 2:
//
//	输入: [4,9,0,5,1]
//	    4
//	   / \
//	  9   0
//	?/ \
//	5   1
//	输出: 1026
//	解释:
//	从根到叶子节点路径 4->9->5 代表数字 495.
//	从根到叶子节点路径 4->9->1 代表数字 491.
//	从根到叶子节点路径 4->0 代表数字 40.
//	因此，数字总和 = 495 + 491 + 40 = 1026.
public class L129求根到叶子节点数字之和 {
	public static  class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 StringBuilder stringBuilder ;
	    int res;
	    public int sumNumbers(TreeNode root) {
	        if(root == null) {
	            return 0;
	        }
	        stringBuilder = new StringBuilder();
	        res = 0;
	        backTracking(root);
	        return res;
	    }
	    private void backTracking(TreeNode root){
	        if(root == null) return ;
	         stringBuilder.append(String.valueOf(root.val));
	        if(root.left == null && root.right == null) {
	            int a = Integer.parseInt(stringBuilder.toString());
	            res += a;
	        }
	        backTracking(root.left);
	        
	        backTracking(root.right);
	        stringBuilder.deleteCharAt(stringBuilder.length()-1);
	        

	    }
}
