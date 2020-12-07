package HOT100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L236二叉树的最近公共祖先 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public Object b;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (p.val == root.val)	
			return p;
		if (q.val == root.val)
			return q;	
		if(searchNode(root.right,q,p)&&searchNode(root.left,q,p)) return root;
		if(searchNode2(root.left, q, p,0)) lowestCommonAncestor(root.left,q,p);
		if(searchNode2(root.right, q,p,0)) lowestCommonAncestor(root.right,q,p);
		return null;
	}

	private boolean searchNode2(TreeNode root, TreeNode q, TreeNode p,int flag) {
		if(root==null) return false;
		if(flag==2) return true;
		if(root.val==q.val||root.val==p.val ) {
			flag ++;
		}
		return searchNode2(root.left,q,p, flag)||searchNode2(root.right,q,p, flag);
	}

	private boolean searchNode(TreeNode root, TreeNode q, TreeNode p) {
			if(root==null) return false;
			if(root.val==q.val||root.val ==p.val ) {
				return true;
			}
			return searchNode(root.left,q,p)||searchNode(root.right,q,p);
		}
	 public boolean validateStackSequences(int[] pushed, int[] popped) {
		    Stack<Integer> stack = new Stack<>();
		    int a =0;
		    int b =0;
		    stack.push(pushed[a]);
		    while(true){
		        while(stack.peek()==popped[b]){
		            stack.pop();
		            b++;
		        }
		        a++;
		        if(a==pushed.length) break;
		        stack.push(pushed[a]);
		    }
		    return stack.isEmpty();     
		    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a1 = new TreeNode(2);
		TreeNode a2 = new TreeNode(3);
//		root.left = a1;
//		root.right = a2;
		TreeNode a3 = new TreeNode(1);
		String a = new String("ab"); // a 为一个引用
       
		
	}
}
