package 剑指offer;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//现有矩阵 matrix 如下：
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//给定 target = 5，返回 true。
//
//给定 target = 20，返回 false。
public class Two {
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		// 二分法代码晦涩不推荐
		int cow = matrix[0].length-1;
		int cows = 0;
		int rows = matrix.length - 1;
		while (rows >= 0 && cows <= cow) {
			if (matrix[rows][cows] < target) {
				rows--;
			} else if (matrix[rows][cows] < target) {
				cows++;
			} else {
				return true;
			}
		}
		return false;
	}
	public static boolean findNumberIn2DArrayy(int[][] matrix, int target) {
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[0].length;j++){
	                if(matrix[i][j]==target){
	                    return true;
	                }else{
	                    return false;
	                }

	            }

	        }
			return false;
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(findNumberIn2DArray(a, 8));
	}

}
