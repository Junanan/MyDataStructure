package ��ָoffer;

public class T11t13 {
//	    	������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ���
//	    	��ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
//	    	���磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����Ϊ3+5+3+7=18���������ܽ��뷽�� [35, 38]����Ϊ3+5+3+8=19��
//	    	���ʸû������ܹ�������ٸ����ӣ�
//	    	�� 1��
//	          ���룺m = 2, n = 3, k = 1
//	    	�����3
	//��ǰ�����ⲻͬ  ���ⲻ��Ҫ���� ��Ϊ�������ǹ̶��ӣ�0,0����ʼ�� ����ֻ��Ҫ֪�������˶��ٸ��� count ++ ����
	//K���㷨Ҳ��Ҫ�������
		public static int movingCount(int m, int n, int k) {
	            boolean[][] visited = new boolean[m][n];
	            return dfs(k, m, n, 0, 0, visited);
	        }

	        private static int dfs(int k, int rows, int cols, int i, int j, boolean[][] visited) {
	            if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]) return 0;
	            visited[i][j] = true;//�����ѱ����ʹ���	
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
