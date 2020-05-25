package 剑指offer;
import BinaryTree.BinaryTree;
import BinaryTree.TreeNode;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//示例 1：
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//示例 2：
//输入：root = [1,2,2,null,3,null,3]
//输出：false
public class T25 {
	  public class TreeNodee {
		      int val;
		     TreeNodee left;
		     TreeNodee right;
		      TreeNodee(int x) { val = x; }
		  }
	  public boolean isSymmetric(TreeNodee root) {
		  if(root == null) return true;
		  return recus(root.left,root.right);
	    }
	private boolean recus(TreeNodee L, TreeNodee R) {
		//叶子节点都为空则为true，结束递归
		if(L==null&&R==null) return true;
		//叶子节点只有一个为空或者不相等时结束递归，返回false
		if(L != null||R != null||L.val!=R.val) return false;
		return recus(L.left, R.right)&&recus(L.right,R.left);
	}
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		TreeNode root = new TreeNode(1);
		a.setRoot(root);
		TreeNode rootr = new TreeNode(3);
		TreeNode rootl = new TreeNode(2);
		root.setLeftNode(rootl);
		root.setRightNode(rootr);
		rootl.setLeftNode(new TreeNode(4));
		rootl.setRightNode(new TreeNode(6));
		rootr.setLeftNode(new TreeNode(6));
		rootr.setRightNode(new TreeNode(7));
	}

}
