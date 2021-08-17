package BFS��DFS;

//����һ��������һЩ 0 �� 1 �ķǿն�ά����?grid ��
//
//һ��?����?����һЩ���ڵ�?1?(��������) ���ɵ���ϣ�����ġ����ڡ�Ҫ������ 1 ������ˮƽ������ֱ���������ڡ�����Լ���?grid ���ĸ���Ե���� 0������ˮ����Χ�š�
//
//�ҵ������Ķ�ά���������ĵ��������(���û�е��죬�򷵻����Ϊ 0 ��)
//
//?
//
//ʾ�� 1:
//
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//�������������������Ӧ����?6��ע��𰸲�Ӧ���� 11 ����Ϊ����ֻ�ܰ���ˮƽ��ֱ���ĸ������ 1 ��
public class L695����������� {
	public static int maxAreaOfIsland(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0) return 0;
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, i, j));
				}
			}
		}
		return res;
	}
	private static int dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
			return 0;
		grid[i][j] = 0;
		int count = 1;
		count += dfs(grid, i + 1, j);
		count += dfs(grid, i, j + 1);
		count += dfs(grid, i - 1, j);
		count += dfs(grid, i, j -1);
		return count;
	}
	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,1},{1,1}};
		System.out.println(maxAreaOfIsland(grid));
	}
}
