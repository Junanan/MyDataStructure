package ��ָoffer;

import java.util.Arrays;
///////�������� n����˳���ӡ���� 1 ������ n λʮ���������������� 3�����ӡ�� 1��2��3 һֱ������ 3 λ�� 999��
//ʾ�� 1:
//����: n = 1
//���: [1,2,3,4,5,6,7,8,9]

///// ���Թ�����   �����int ���� longlong ��N�ܴ��ʱ��᲻�������
public class T16 {
	///// ���ⷵ��int���� Ҳ�������ȥ
	public static int[] printNumbers(int n) {
		int t = (int) Math.pow(10, n);
		int[] a = new int[t - 1];
		int k = 0;
		for (int i = 1; i < t; i++) {
			a[k++] = i;
		}
		return a;
	}

	///// �ݹ�ȫ����
	// �ݹ������������еĿ���
	public void print1ToMaxNDigits_3(int n) {
		if (n <= 0)
			return;

		StringBuffer str = new StringBuffer(n);
		for (int i = 0; i < n; i++) {
			str.append('0');
		}

		for (int i = 0; i < 10; i++) {
			str.setCharAt(0, (char) (i + '0'));
			print1ToMaxNDigits_Recursely(str, n, 0);
		}

	}

	// ����һ���ݹ麯��
	public void print1ToMaxNDigits_Recursely(StringBuffer str, int n, int index) {
		if (index == n - 1) {
			printNumber(str);
		}

		for (int i = 0; i < 10; i++) {
			str.setCharAt(index, (char) (i + '0'));
		}
		print1ToMaxNDigits_Recursely(str, n, index + 1);
	}

	// ��ӡ���֣��ӵ�һ����0���ַ���ʼ��ӡ
	public void printNumber(StringBuffer str) {
		boolean isBeginning0 = true;
		for (int i = 0; i < str.length(); i++) {
			if (isBeginning0 && str.charAt(i) != '0')
				isBeginning0 = false;
			if (!isBeginning0) {
				System.out.println(str.charAt(i));
			}
		}
	}

	public static void main(String[] args) {
		T16 a = new T16();
		a.print1ToMaxNDigits_3(1);
	}

}
