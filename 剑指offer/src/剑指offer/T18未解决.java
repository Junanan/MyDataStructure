package ��ָoffer;

public class T18δ��� {
	 public  static boolean isNumber(String s) {
			 //������ʽ�ⷨ
			         String string = String.valueOf(s);
			         return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
			     }
			 /*
			 ���¶�������н���:
			 [\\+\\-]?            -> ���򸺷��ų������
			 \\d*                 -> ���������Ƿ���֣���-.34 �� +3.34������
			 (\\.\\d+)?           -> �������С���㣬��ôС���������������֣�
			                         ����һ�𲻳���
			 ([eE][\\+\\-]?\\d+)? -> �������ָ�����֣���ôe��E�϶����֣�+��-���Բ����֣�
			                         �����ű�����������������������ֶ�������
			 */
//		 int i=0;
//		 int g=0;
//		char[] c =s.toCharArray();
//		for(int k=0;k<c.length;k++) {
//			if(c[k]=='0'||c[k]=='1'||c[k]=='2'||c[k]=='3'||c[k]=='4'||c[k]=='5'||c[k]=='6'||c[k]=='7'||c[k]=='8'||c[k]=='9'||c[k]=='.') {
//				if(c[0]==0||c[0]=='.') {
//					return false;
//				}
//				if(c[k]=='.') {
//					g++;
//					if(g>1) {
//						return false;
//					}
//				}
//			}else return false;
//		}
//		return true;
	
	 public static void main(String[] args) {
		String s=".";
		System.out.println(isNumber(s));
	}

}
