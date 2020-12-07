package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
//		   Pattern pattern = Pattern.compile("\\d?");
//		   Matcher matcher = pattern.matcher("lkl123jkjl?");
////		   System.out.println(matcher.group());
//		   System.out.println(matcher.matches());
//		   System.out.println(matcher.pattern());
//		   System.out.println(uniqueOccurrences(new int[] {1,2,2,3,1,1}));
		TreeNode root = new TreeNode(5);
		TreeNode root2 = new TreeNode(4);
		TreeNode root3 = new TreeNode(8);
		TreeNode root4 = new TreeNode(11);
		TreeNode root5 = new TreeNode(13);
		TreeNode root6 = new TreeNode(4);
		TreeNode root7 = new TreeNode(7);
		TreeNode root8 = new TreeNode(2);
		TreeNode root9 = new TreeNode(1);
		root.left = root2;
		root2.left = root4;
		root4.left = root7;
		root4.right = root8;
		root.right = root3;
		root3.left = root5;
		root3.right = root6;
		root6.right = root9;
//		   System.out.println(sumNumbers(root));
//		   System.out.println(topKFrequent(new int[]{3,0,1,0},1));
//		  int[][] arr = new int[][] {{1,23},{2,4},{3,3}};
//		   for (int[] a : arr) {
//			   System.out.println(Arrays.toString(a));
//		   }
//		   StringBuilder s = new StringBuilder();
//		   s.append('2');
//		   s.append('5');
//		   s.append('2');
//		   s.replace(0, 2, "8");
//		   System.out.println(s.toString());
//		System.out.println(hasPathSum(root,22));
//		   System.out.println(Arrays.toString(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
//		System.out.println(reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		for(Integer s:set ) { 
			System.out.println(s);
		}
	}
	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people,(a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		List<int []> list = new LinkedList<>();
		for(int[] p : people) {
			list.add(p[1],p);
		}
		int[][] res = new int[list.size()][2];
		int a = 0;
		for(int[] i : list) {
			res[a++] = i;
		}
		return res;
  }
	static boolean res;
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        backtracking(root,sum);
        return res;
    }
	private static void backtracking(TreeNode root, int sum) {
		if ( root ==null) return ;
		
		sum -= root.val;
		if(sum == 0&&root.left==null&&root.right==null) {
			res = true;
		}
		backtracking(root.left,sum);
		backtracking(root.right,sum);
	}
}
