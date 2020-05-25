package λ����;

import java.util.Arrays;

//һ���������� nums �����������֮�⣬�������ֶ����������Ρ�
//��д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
//ʾ�� 1��
//
//���룺nums = [4,1,4,6]
//�����[1,6] �� [6,1]
//ʾ�� 2��
//
//���룺nums = [1,2,10,4,1,4,3,3]	
//�����[2,10] �� [10,2]
public class T54 {
	public static int[] singleNumbers(int[] nums) {
		int mask = 1;
		int k = 0;
		int a = 0, b = 0;
//		num1:       101110      110     1111
//		num2:       111110      001     1001
//		num1^num2:  010000      111     0110
//
//		���е�mask:  010000      001     0010
//		                        010     0100
//		                        100    
		for (int i : nums) {
			k ^= i;
		}
		// ��������� �ҳ���������ͬ���� ���λ�Ĳ�ͬ��ֵ
		while ((k & mask) == 0) {
			mask <<= 1;
		}
		// ��ͬ�����ֿ϶�Ϊͬһ��
		for (int i : nums) {
			if ((i & mask) == 0) {
				a ^= i;
			} else {
				b ^= i;
			}
		}
		return new int[] { a, b };
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4,1,4,6};
		System.out.println(Arrays.toString(singleNumbers(a)));
	}
}
