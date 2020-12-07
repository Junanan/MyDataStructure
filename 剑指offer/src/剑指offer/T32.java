package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
//如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//参考以下这颗二叉搜索树：	
//     5
//    / \
//   2   6
//  / \
// 1   3
//示例 1：
//输入: [1,6,3,2,5]
//输出: false
//示例 2：
//输入: [1,3,2,6,5]
//输出: true
public class T32 {
	public boolean verifyPostorder(int[] postorder) {
		// 递归法 根据后序遍历与二叉排序树的性质
		// 先找出第一个大于根节点（postorder[j]）的数，此数的左边就为左子区间，右边就为右子树区间
		// 在寻找比根节点大的时候已经判断了左子树区间的正确性，所以只需要在确定右子树区间的正确性即可
		return recus(postorder, 0, postorder.length - 1);
	}

	private boolean recus(int[] po, int i, int j) {
		if (i >= j)
			return true;
		int l = i;
		while (po[l] < po[j])
			l++;// 找比根节点的大的值
		int m = l;//
		while (po[l] > po[j])
			l++;// 确定右子树区间的正确性
		return l == j && recus(po, i, m - 1) && recus(po, m, j - 1);//递归左子区间与右子区间
	}
//  单调栈 
	public static boolean verifyPostorderr(int[] postorder) {
		// 单调栈使用，单调递增的单调栈
		Deque<Integer> stack = new LinkedList<>();
		// 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
		int root = Integer.MAX_VALUE;
		// 逆向遍历，就是翻转的先序遍历
		for (int i = postorder.length - 1; i >= 0; i--) {
			// 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
			if (postorder[i] > root) {
				return false;
			}	
			while (!stack.isEmpty() && stack.peek()> postorder[i]) {
				// 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
				// 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
				root = stack.pop();
			}
			// 这个新元素入栈
			stack.push(postorder[i]);
			
		}
		return true;
	}
	public static void main(String[] args) {
		int[] a = new int[] {1,3,2,6,9,8,5};
		System.out.println(verifyPostorderr(a));
	}
}
