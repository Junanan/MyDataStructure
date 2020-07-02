package BFS��DFS;

import java.util.LinkedList;
import java.util.List;

//���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
//
// 
//
//ʾ����
//
//���룺n = 3
//�����[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
public class L22�������� {
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
		//��֦
		if(left<right) return;
		 dfs(left+1,right,string+"(");
		 dfs(left,right+1,string+")");
		
	}

}
