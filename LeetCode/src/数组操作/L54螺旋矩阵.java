package 数组操作;

import java.util.ArrayList;
import java.util.List;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//示例 1:
//
//输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//示例 2:
//
//输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
public class L54螺旋矩阵 {
	public static List<Integer> spiralOrder(int[][] matrix) {
 		if(matrix.length==0) return new ArrayList<Integer>();
		int m = matrix.length,n = matrix[0].length;
		int top =0,down = m-1,left = 0 , right = n-1;
		List<Integer> res = new ArrayList<>();
		while(true) {
			for(int i = left;i<=right;i++) res.add(matrix[top][i]);
			if(++top>down) break;
			for(int i = top;i<=down;i++) res.add(matrix[i][right]);
			if(left>--right) break;
			for(int i = right;i>=left;i--) res.add(matrix[down][i]);
			if(top>--down) break;
			for(int i = down;i>=top;i--) res.add(matrix[i][left]);
			if(++left>right) break;
		}
		return res;
    }
	public static void main(String[] args) {
		int[][] a = new int[][] {{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }};
		System.out.println(spiralOrder(a));
	}
}
