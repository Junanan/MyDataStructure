package 字符串操作;

import java.util.ArrayList;
import java.util.List;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
//
// 
//
//示例 1：
//
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
public class L763划分字母区间 {
	// 贪心
	public static List<Integer> partitionLabels(String S) {
		int[] last = new int[26]; // 最后出现 对应的下标
		for (int i = 0; i < S.length(); ++i) { // ++i 与 i++ 结果没有区别 但是在大量数据的时候 ++i 性能更加好些
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
