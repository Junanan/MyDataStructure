package 画图让抽象问题形象化;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//示例 1：
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//示例 2：
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
import java.nio.charset.MalformedInputException;
import java.util.Arrays;

public class T26 {
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix.length==0) return new int[0];
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;//l左边界,r为右边界,t上边界,b为下边界
		int[] temp = new int[(r+1)*(b+1)];
		while(true) {
			for(int i =l ;i<=r;i++) temp[x++] = matrix[t][i];//左到右
			if(++t>b) break;
			for(int i = t;i<=b;i++) temp[x++] = matrix[i][r];//上到下
			if(--r<l) break;
			for(int i=r;i>=l;i--) temp[x++] = matrix[b][i];
			if(--b<t) break;
			for(int i=b;i>=t;i--) temp[x++] = matrix[i][l];
			if(++l>r) break;
		}
		return temp;
    }
public static void main(String[] args) {
	int[][] a =new int[][] {{1,2,3},{1,2,3},{1,2,4}};
   System.out.println(Arrays.toString(spiralOrder(a)));			
}

}
