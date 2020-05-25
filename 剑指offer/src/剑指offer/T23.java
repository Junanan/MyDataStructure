package 剑指offer;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//例如:
//给定的树 A:
//     3
//    / \
//   4   5
//  / \
// 1   2
//给定的树 B：
//   4 
//  /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
public class T23 {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  // 这道题B[4,1]  默认是前序遍历 1为左子节点
	  //递归遍历树   方法DFS深度优先对列
	  public boolean isSubStructure(TreeNode A, TreeNode B) {
		  if(A==null||B==null) return false;
		  return dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);//dfs判断根节点，isSubStructure(A.left,B)判断是否为左子树，isSubStructure(A.right,B)判断是否为右子树
		  //这种遍历类似前序遍历  ,  '||' 只要一个为true就结束
	    }

	private boolean dfs(TreeNode A, TreeNode B) {
		if(B == null) return true;//节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true；
		if(A == null|| A.val!=B.val) return false;//B不为空，而A为空，肯定不等
		return dfs(A.left,B.left)&&dfs(A.right,B.right);//左边右边都要判断&&
	}

}
