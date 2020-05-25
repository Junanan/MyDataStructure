package 动态规划;

public class L174 {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}
		int rowLen = dungeon.length;
		int colLen = dungeon[0].length;
		// 最低的耗血量为 + 1；就是骑士的救公主的最低血量。
		return dfs(0, 0, rowLen, colLen, dungeon) + 1;
	}

	public int dfs (int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon) {
		//
		if (rowIndex >= rowSize || colIndex >= colSize) {
			return Integer.MAX_VALUE;
		}
		// 退出条件
		if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
			if (dungeon[rowIndex][colIndex] >= 0) {
				// 如果最后一个大于等于0，就返还0。
				return 0;
			} else {
				//如果最后一个小于零，就返回负的值。
				return -dungeon[rowIndex][colIndex];
			}
		}
	//  右边格子的最优解，也就是最低的耗血量
		int rightMin = dfs(rowIndex, colIndex + 1, rowSize, colSize, dungeon);
	//  下边格子的最优解
		int downMin = dfs(rowIndex + 1, colIndex, rowSize, colSize, dungeon);
		// f(i,j) = min(f(i+1, j), f(i, j+1)) - dungeon[i][j]
		int needMin = Math.min(rightMin, downMin) - dungeon[rowIndex][colIndex];
		int res = 0;
		if (needMin < 0) {
			res =  0;
		} else {
			res = needMin;
		}
		System.out.println(rowIndex+ " "+colIndex + " "  + res);
		return res;
	}
}
