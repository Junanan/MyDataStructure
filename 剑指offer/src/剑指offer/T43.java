package ��ָoffer;

//����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����
//һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
//ʾ�� 1:
//����: 12258 
//���: 5
//����: 12258��5�ֲ�ͬ�ķ��룬�ֱ���"bccfi", "bwfi", "bczi", "mcfi"��"mzi"
public class T43 {
	static int count = 0;

	public static int translateNum(int num) {
		String a = String.valueOf(num);
		backtracking(a, 0);
		return count;
	}

	private static void backtracking(String a, int i) {
		if (i >= a.length()) {
			count++;
			return;
		}
		backtracking(a, i+1);
		if(i<a.length()-1&&a.substring(i, i+1)!="0"&&(Integer.valueOf(a.substring(i, i+2))>=0&&(Integer.valueOf(a.substring(i, i+2))<=25))){
			backtracking(a, i+2);
		}
	}

	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}

}
