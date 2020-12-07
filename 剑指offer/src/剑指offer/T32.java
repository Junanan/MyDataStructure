package ��ָoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������
//������򷵻� true�����򷵻� false���������������������������ֶ�������ͬ��
//�ο�������Ŷ�����������	
//     5
//    / \
//   2   6
//  / \
// 1   3
//ʾ�� 1��
//����: [1,6,3,2,5]
//���: false
//ʾ�� 2��
//����: [1,3,2,6,5]
//���: true
public class T32 {
	public boolean verifyPostorder(int[] postorder) {
		// �ݹ鷨 ���ݺ�����������������������
		// ���ҳ���һ�����ڸ��ڵ㣨postorder[j]����������������߾�Ϊ�������䣬�ұ߾�Ϊ����������
		// ��Ѱ�ұȸ��ڵ���ʱ���Ѿ��ж����������������ȷ�ԣ�����ֻ��Ҫ��ȷ���������������ȷ�Լ���
		return recus(postorder, 0, postorder.length - 1);
	}

	private boolean recus(int[] po, int i, int j) {
		if (i >= j)
			return true;
		int l = i;
		while (po[l] < po[j])
			l++;// �ұȸ��ڵ�Ĵ��ֵ
		int m = l;//
		while (po[l] > po[j])
			l++;// ȷ���������������ȷ��
		return l == j && recus(po, i, m - 1) && recus(po, m, j - 1);//�ݹ�������������������
	}
//  ����ջ 
	public static boolean verifyPostorderr(int[] postorder) {
		// ����ջʹ�ã����������ĵ���ջ
		Deque<Integer> stack = new LinkedList<>();
		// ��ʾ��һ�����ڵ��Ԫ�أ�������԰�postorder�����һ��Ԫ��root���������ڵ������
		int root = Integer.MAX_VALUE;
		// ������������Ƿ�ת���������
		for (int i = postorder.length - 1; i >= 0; i--) {
			// ������Ԫ�ر���ҪС�ڵ���ջ��peek���ʵ�Ԫ�أ�����Ͳ��Ƕ���������
			if (postorder[i] > root) {
				return false;
			}	
			while (!stack.isEmpty() && stack.peek()> postorder[i]) {
				// ����Ԫ��С�ڵ���ջ��Ԫ���ˣ���ʾ�����������ˣ���¼���ϸ����ڵ�
				// �ҵ������������Ӧ�ĸ��ڵ㣬֮ǰ������ȫ�����������ټ�¼����Ϊ�������������ڵ������������
				root = stack.pop();
			}
			// �����Ԫ����ջ
			stack.push(postorder[i]);
			
		}
		return true;
	}
	public static void main(String[] args) {
		int[] a = new int[] {1,3,2,6,9,8,5};
		System.out.println(verifyPostorderr(a));
	}
}
