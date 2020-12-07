package HOT100;

import java.util.HashMap;
//����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
//
//ʾ�� 1:
//
//����: "abcabcbb"
//���: 3 
//����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
//ʾ�� 2:
//
//����: "bbbbb"
//���: 1
//����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
//ʾ�� 3:
//
//����: "pwwkew"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
//     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
public class L3���ظ��ַ�����Ӵ� {
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) return 0;
		char[] a = s.toCharArray();
		HashMap<Character,Integer > map = new HashMap<>();
		int res =0;
		int left =0;
		for(int end =0;end<a.length;end++) {
			if(map.size()!=0&&map.containsKey(a[end])) {
				left = Math.max(left,map.get(a[end])+1);
			}
			res = Math.max(res, end+1-left);
			map.put(a[end], end);
		}
		return res;
	}
}
