package ��ָoffer;

//����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����
//һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
//ʾ�� 1:
//����: 12258 
//���: 5
//����: 12258��5�ֲ�ͬ�ķ��룬�ֱ���"bccfi", "bwfi", "bczi", "mcfi"��"mzi"
public class T43 {
	public static int translateNum(int num) {
		String s = String.valueOf(num);
		int a = 1;
		int b = 1;
		for (int i = 2; i <= s.length(); i++) {
			String tem = s.substring(i - 2, i);
			int c = tem.compareTo("0") >= 0 && tem.compareTo("25") <= 0 ? a + b : a;
			b = a;
			a = c;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}

}
