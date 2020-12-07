package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Five {
//	输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//	例如，给出
//	前序遍历 preorder = [3,9,20,15,7]
//	中序遍历 inorder = [9,3,15,20,7]
//	返回如下的二叉树：
//
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
		    //把前序遍历的值和中序遍历的值放到list中
		    List<Integer> preorderList = new ArrayList<>();
		    List<Integer> inorderList = new ArrayList<>();
		    for (int i = 0; i < preorder.length; i++) {
		        preorderList.add(preorder[i]);
		        inorderList.add(inorder[i]);
		    }
		    return helper(preorderList, inorderList);
		}

		private TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {
		    if (inorderList.size() == 0)
		        return null;
		    //前序遍历的第一个值就是根节点
		    int rootVal = preorderList.remove(0);
		    //创建跟结点
		    TreeNode root = new TreeNode(rootVal);
		    //查看根节点在中序遍历中的位置，然后再把中序遍历的数组劈两半，前面部分是
		    //根节点左子树的所有值，后面部分是根节点右子树的所有值
		    int mid = inorderList.indexOf(rootVal);
		    //[0，mid)是左子树的所有值，inorderList.subList(0, mid)表示截取inorderList
		    //的值，截取的范围是[0，mid)，包含0不包含mid。
		    root.left = helper(preorderList, inorderList.subList(0, mid));
		    //[mid+1，inorderList.size())是右子树的所有值，
		    // inorderList.subList(mid + 1, inorderList.size())表示截取inorderList
		    //的值，截取的范围是[mid+1，inorderList.size())，包含mid+1不包含inorderList.size()。
		    root.right = helper(preorderList, inorderList.subList(mid + 1, inorderList.size()));
		    return root;
		}
	
	}
    Set<String> res ;
   public String[] permutation(String s) {
       res = new HashSet<>();
       boolean[] isValid = new boolean[s.length()];
       StringBuilder stringbuilder = new StringBuilder();
       BackTracking(s,stringbuilder,isValid);
       return res.toArray(new String[res.size()]);
   }
   private void BackTracking(String s,StringBuilder stringbuilder, boolean[] isValid ){
       if(stringbuilder.length()==s.length()) {
           res.add(stringbuilder.toString());
           return ;
       }
       for(int i=0;i<s.length();i++){
           if(isValid[i]) continue;
           isValid[i] = true;
           stringbuilder.append(s.charAt(i));
           BackTracking(s,stringbuilder,isValid);
           isValid[i] = false;
           stringbuilder.deleteCharAt(stringbuilder.length()-1);
       }
   }
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		int[] a = new int[2] ;
		int b =0;
		   PriorityQueue<Integer> queue = new PriorityQueue<>((a1,a2)->a2-a1);
		   queue.add(1);
		   queue.add(2);
		   for(Integer i :queue) {
			   a[b++] = i;
		   }
		   System.out.println(Arrays.toString(a));
	}
}

