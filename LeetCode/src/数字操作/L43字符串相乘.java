package 数字操作;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//示例 1:
//
//输入: num1 = "2", num2 = "3"
//输出: "6"
//示例 2:
//
//输入: num1 = "123", num2 = "456"
//输出: "56088"
public class L43字符串相乘 {
	public static String multiply(String num1, String num2) {
		if(num1.equals("0")||num2.equals("0")) return "0";
		int[] res = new int[num1.length()+num2.length()];
		for(int i = num1.length()-1;i>=0;--i) {
			int n = num1.charAt(i)-'0';
			for(int j =num2.length()-1;j>=0;--j) {
				int m = num2.charAt(j)-'0';
				int sum = n*m;
				res[i+j+1] = (res[i+j+1]+sum) % 10;
				res[i+j] =res[i+j]+(res[i+j+1]+sum)/10;
			}
		}
		StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
	public static void main(String[] args) {
		System.out.println(multiply("123","456"));
	}
}
