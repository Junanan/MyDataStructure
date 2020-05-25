package 剑指offer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//输入一个字符串，打印出该字符串中字符的所有排列。
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//示例:
//输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
public class T36 {
	static List<String> res = new LinkedList<>();
	static char[] c;
	public static String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		String[] a = new String[res.size()];
		return res.toArray(a);
	}
	 static void dfs(int x) {
		if (x == c.length - 1) {
			res.add(String.valueOf(c)); // 添加排列方案
			return;	
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {
			if (set.contains(c[i])) continue; // 重复，因此剪枝  例如 s=aab
			set.add(c[i]);
			swap(i, x); // 交换，固定此位为 c[i]
			dfs(x + 1); // 开启固定第 x + 1 位字符
			swap(i, x); // 恢复交换 例如 acb 不换回abc的话  则会变成cab 会乱
		}
	}

	 static void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
	 public static void main(String[] args) {
		String s = "abcd";
		System.out.println(Arrays.toString(permutation(s)));
	}
}
