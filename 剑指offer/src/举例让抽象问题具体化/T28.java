package �����ó���������廯;

import java.util.Stack;

//���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ����磬���� {1,2,3,4,5} ��ĳջ��ѹջ���У�
//���� {4,5,3,2,1} �Ǹ�ѹջ���ж�Ӧ��һ���������У��� {4,3,5,1,2} �Ͳ������Ǹ�ѹջ���еĵ������С�
//ʾ�� 1��
//
//���룺pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//�����true
//���ͣ����ǿ��԰�����˳��ִ�У�
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//ʾ�� 2��
//
//���룺pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//�����false 
//���ͣ�1 ������ 2 ֮ǰ������
  ////////////

public class T28 {
	//̰���㷨   ʹ�ø���ջ   popped ��һ�����鲻��ջ
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> a = new Stack<>();// ����ʡInteger ����popped[j] �ᱨ��
		int j = 0;
		int n = popped.length;
		for (int i = 0; i < pushed.length; i++) {
			a.push(pushed[i]);
			while (!a.isEmpty() && j < n && a.peek() == popped[j]) {
				a.pop();
				j++;
			}
		}
		return a.isEmpty();
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = new int[] { 4, 5, 3, 2, 1 };
		int[] c = new int[] {4,3,5,1,2};
		System.out.println(validateStackSequences(a, b));
		System.out.println(validateStackSequences(a, c));
	}
}
