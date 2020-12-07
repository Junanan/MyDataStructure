package 正则;

import java.util.regex.*;

public class L1 {
	public static void main(String[] args) {
		///实现方式1，匹配一个数字。
		// 要匹配的字符
		String str = "8";
         //正则表达式
		String regex = "[0-9]";
         //返回匹配的结果，匹配成功就返回true，失败就返回false，此次匹配返回true。
		boolean flag = Pattern.matches(regex, str);
		System.out.println(flag);
		
		//实现方式2, 匹配3个到5个字母，大小写不限，包括3和5个。
		//要匹配的字
	    String str2 = "hello";
		//正则表达式
		String regex2 = "[a-zA-Z]{3,5}";
		//输出匹配的结果, 此次匹配返回true。
		System.out.println(str2.matches(regex2));
		
		////实现方式3(此种实现方式最快)， 匹配11位的电话号码，匹配规则：第一个数字是1，第二个数字是2,3,7,8中任一个，后面9位数字中不包含4。
		//要匹配的字符
		String str3 = "13656231253";
		//正则表达式
		String regex3 = "1[2378][0-35-9]{9}";
		//将给定的正则表达式编译为模式。 如果匹配需求较多，且需用同相同的regex去匹配，就可将这句写到静态模块里面，用的时候直接使用实例p
		Pattern p = Pattern.compile(regex3);
		//创建一个匹配器，匹配给定的输入与此模式。
		Matcher m = p.matcher(str3);
		//尝试将整个区域与模式进行匹配。
		boolean flag2 = m.matches();
		//输出匹配结果，此次结果为true
		System.out.println(flag2);
		
		///替换
		//要匹配的字符
		String str4 = "12a6B985Ccv65";
		//正则表达式
		String regex4 = "[a-zA-Z]+";
		//正则表达式
		String regex44 = "\\d+";
		//将字符串中英文字母替换为&符号，输出12&6&985&65
		System.out.println(str4.replaceAll(regex4, "&"));
		//将字符串中单个数字或者连续的数字替换为0，输出0a0B0Ccv0
		System.out.println(str4.replaceAll(regex44,"0"));
		
		//切割，根据大写字母切割字符串
		String str5 = "oneTtowTthreeDfourJfive";
		String regex5 = "[A-Z]";
		String[] arr = str5.split(regex5);
		for (String s: arr) {
		System.out.print(s + " ");
	}
}
}
