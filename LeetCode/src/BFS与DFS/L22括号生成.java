package BFS与DFS;

import java.util.LinkedList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
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
	int n;
	List<String> res;
	public List<String> generateParenthesis(int n) {
		this.n = n;
		res = new LinkedList<String>();
		dfs(0,0,"");
		return res;
    }
	private void dfs(int left, int right, String string) {
		if(left>n||right>n) return;
		if(left==n&&right==n) {
			res.add(string);
			return;
		}
		//剪枝
		if(left<right) return;
		 dfs(left+1,right,string+"(");
		 dfs(left,right+1,string+")");
		
	}

}
