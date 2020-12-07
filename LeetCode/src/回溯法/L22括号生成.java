package 回溯法;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对 数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//示例：
//
//输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ] 
public class L22括号生成 {
	List<String> res ;
	 public List<String> generateParenthesis(int n) {
		 res = new ArrayList<String>();
		 StringBuilder track = new StringBuilder();
		 backtrack(n,0,0,track);
		 return res;
	    }
	private void backtrack(int n, int left, int right,StringBuilder track) {
		if(left<right) return;
		if(left>n||right>n) return; ////
		if(left==n&&right==n) {
			res.add(track.toString());
			return;
		}
		track.append("(");//做出选择
		backtrack(n, left+1, right, track);//进入下一步决策
		track.deleteCharAt(track.length()-1);//撤销选择
		
		track.append(")");
		backtrack(n, left, right+1, track);
		track.deleteCharAt(track.length()-1);
	}
	public static void main(String[] args) { 
		 StringBuilder track = new StringBuilder();
		 track.append("123");
		 System.out.println(track.length());
		 track.substring(track.length()-1);
		 System.out.println(track);
	}
	
}