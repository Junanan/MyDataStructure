package Daily;

//����: [1,2,3]
//	    1
//	   / \
//	  2   3
//	���: 25
//	����:
//	�Ӹ���Ҷ�ӽڵ�·�� 1->2 �������� 12.
//	�Ӹ���Ҷ�ӽڵ�·�� 1->3 �������� 13.
//	��ˣ������ܺ� = 12 + 13 = 25.
//	ʾ�� 2:
//
//	����: [4,9,0,5,1]
//	    4
//	   / \
//	  9   0
//	?/ \
//	5   1
//	���: 1026
//	����:
//	�Ӹ���Ҷ�ӽڵ�·�� 4->9->5 �������� 495.
//	�Ӹ���Ҷ�ӽڵ�·�� 4->9->1 �������� 491.
//	�Ӹ���Ҷ�ӽڵ�·�� 4->0 �������� 40.
//	��ˣ������ܺ� = 495 + 491 + 40 = 1026.
public class L129�����Ҷ�ӽڵ�����֮�� {
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
