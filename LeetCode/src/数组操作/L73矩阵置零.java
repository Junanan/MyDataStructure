package 数组操作;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//
//示例 1:
//
//输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//示例 2:
//
//输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
public class L73矩阵置零 {
	// O(1) 空间
	public static void setZeroes(int[][] matrix) {
		int rowlen = matrix.length;
		int cowlen = matrix[0].length;
		boolean row0 = false;
		boolean col0 = false;
		// 判断第一列是否有0
		for (int i = 0; i < rowlen; i++) {
			if (matrix[i][0] == 0)
				col0 = true;
		}
		// 判断第一行是否有0
		for (int i = 0; i < cowlen; i++) {
			if (matrix[0][i] == 0)
				row0 = true;
		}
		// 将第一行 第一列做标记位
		for (int i = 1; i < rowlen; i++) {
			for (int j = 1; j < cowlen; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		// 置0
		for (int i = 1; i < rowlen; i++) {
			for (int j = 1; j < cowlen; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (row0) {
			for (int i = 0; i < rowlen; i++) {
				matrix[i][0] = 0;
			}
		}
		if (col0) {
			for (int j = 0; j < cowlen; j++) {
				matrix[0][j] = 0;
			}
		}
	}
	/// O(m+n)空间
	public void setZeroess(int[][] matrix) {
		Set<Integer> row_zero = new HashSet<>();
		Set<Integer> col_zero = new HashSet<>();
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					row_zero.add(i);
					col_zero.add(j);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (row_zero.contains(i) || col_zero.contains(j))
					matrix[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 0, 2, 3 }, { 4, 1, 6 }, { 7, 8, 9 } };
		setZeroes(a);
		System.out.println(Arrays.deepToString(a));
	}
}
