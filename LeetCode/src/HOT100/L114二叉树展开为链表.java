package HOT100;

import HOT100.L105��ǰ��������������й��������.TreeNode;

//����һ����������ԭ�ؽ���չ��Ϊһ��������
//
// 
//
//���磬����������
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//����չ��Ϊ��
//
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
public class L114������չ��Ϊ���� {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	// ʹ�õݹ� ��root ��������Ū����չ��Ϊ����  ǧ�������ϸ��
	 public void flatten(TreeNode root) {
	        if(root==null) return ;
	        flatten(root.left);
	        flatten(root.right);
	        TreeNode temp = root.right;
	        root.right = root.left;
	        root.left = null;
	        //��ԭ�ȵ�right�ӵ� left�ĺ��
	        while(root.right!=null) {
	        	root = root.right;
	        }
	        root.right = temp;
	   }
	 public static void main(String[] args) {
		System.out.println(1&1);
	}
}
