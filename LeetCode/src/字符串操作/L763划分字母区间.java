package �ַ�������;

import java.util.ArrayList;
import java.util.List;

//�ַ��� S ��Сд��ĸ��ɡ�����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ����ĸֻ����������е�һ��Ƭ�Ρ�����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
//
// 
//
//ʾ�� 1��
//
//���룺S = "ababcbacadefegdehijhklij"
//�����[9,7,8]
//���ͣ�
//���ֽ��Ϊ "ababcbaca", "defegde", "hijhklij"��
//ÿ����ĸ��������һ��Ƭ���С�
//�� "ababcbacadefegde", "hijhklij" �Ļ����Ǵ���ģ���Ϊ���ֵ�Ƭ�������١�
public class L763������ĸ���� {
	// ̰��
	public static List<Integer> partitionLabels(String S) {
		int[] last = new int[26]; // ������ ��Ӧ���±�
		for (int i = 0; i < S.length(); ++i) { // ++i �� i++ ���û������ �����ڴ������ݵ�ʱ�� ++i ���ܸ��Ӻ�Щ
			last[S.charAt(i) - 'a'] = i;
		}
		List<Integer> res = new ArrayList<>();
		int start = 0, j = 0;
		for (int i = 0; i < S.length(); ++i) {
			j = Math.max(j, last[S.charAt(i) - 'a']);
			if (i == j) {
				res.add(i - start + 1);
				start = i + 1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String a = "ababcbacadefegdehijhklij";
		partitionLabels(a);
	}

}
