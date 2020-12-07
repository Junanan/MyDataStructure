package 剑指offer;

public class T11t13 {
//	    	地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
//	    	它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
//	    	例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
//	    	请问该机器人能够到达多少个格子？
//	    	例 1：
//	          输入：m = 2, n = 3, k = 1
//	    	输出：3
	//与前面那题不同  这题不需要遍历 因为机器人是固定从（0,0）开始的 而且只需要知道它走了多少格子 count ++ 就行
	//K的算法也需要另外记忆
		public static int movingCount(int m, int n, int k) {
	            boolean[][] visited = new boolean[m][n];
	            return dfs(k, m, n, 0, 0, visited);
	        }

	        private static int dfs(int k, int rows, int cols, int i, int j, boolean[][] visited) {
	            if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]) return 0;
	            visited[i][j] = true;//代表已被访问过了	
	            if (digitSum(i) + digitSum(j) > k) return 0;
	            int count = 1; 
	            count += dfs(k, rows, cols, i-1, j, visited);
	            count += dfs(k, rows, cols, i+1, j, visited);
	            count += dfs(k, rows, cols, i, j-1, visited);
	            count += dfs(k, rows, cols, i, j+1, visited);
	            return count;
	        }
	        private static int digitSum(int num) {
	            int sum = 0;
	            while (num != 0) {
	                sum += num % 10;
	                num = num / 10;
	            }
	            return sum;
	        }
	       
	
	 public static void main(String[] args) {
		 System.out.println(movingCount(3,1,0));
		}
}
