package KMP;



// PMT����Ϊ ǰ��׺��ͬ�ַ��� Ϊ���� ��������ƫ��һλ�õ�next�����һλΪ-1��
public class KMP {
	public static int kmp(String str, String patten) {
		int i = 0;
		int j = 0;
		int[] next = getnext(patten);
		while (i < str.length() && j < patten.length()) {
			if (j == -1 || str.charAt(i) == patten.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j]; // �൱��str�������ƶ��� ��ƥ��x - next[j]
			}
		}

		// ƥ��ɹ�������ģʽ��str���ı�str�е�λ�ã����򷵻�-1
		if (j == patten.length()) {
			return i - j;
		} else
			return -1;
	}
	//��ʵ����next����Ĺ�����ȫ���Կ����ַ���ƥ��Ĺ��̣�����ģʽ�ַ���Ϊ���ַ�������ģʽ�ַ�����ǰ׺ΪĿ���ַ�����
	// һ���ַ���ƥ��ɹ�����ô��ǰ��nextֵ����ƥ��ɹ����ַ����ĳ��ȡ�
	private static int[] getnext(String str) {
		int[] next = new int[str.length() + 1];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < str.length()) {
			if (j == -1 || str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;
	}

	public static void main(String[] args) {
		System.out.println(kmp("abcdeas","as"));
		getnext("abababca");
	}
}
