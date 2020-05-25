package 剑指offer;

public class T18未解决 {
	 public  static boolean isNumber(String s) {
			 //正则表达式解法
			         String string = String.valueOf(s);
			         return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
			     }
			 /*
			 以下对正则进行解释:
			 [\\+\\-]?            -> 正或负符号出现与否
			 \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
			 (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
			                         否则一起不出现
			 ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
			                         紧接着必须跟着整数；或者整个部分都不出现
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
