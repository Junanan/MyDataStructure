package ��̬�滮;

public class L174 {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}
		int rowLen = dungeon.length;
		int colLen = dungeon[0].length;
		// ��͵ĺ�Ѫ��Ϊ + 1��������ʿ�ľȹ��������Ѫ����
		return dfs(0, 0, rowLen, colLen, dungeon) + 1;
	}

	public int dfs (int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon) {
		//
		if (rowIndex >= rowSize || colIndex >= colSize) {
			return Integer.MAX_VALUE;
		}
		// �˳�����
		if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
			if (dungeon[rowIndex][colIndex] >= 0) {
				// ������һ�����ڵ���0���ͷ���0��
				return 0;
			} else {
				//������һ��С���㣬�ͷ��ظ���ֵ��
				return -dungeon[rowIndex][colIndex];
			}
		}
	//  �ұ߸��ӵ����Ž⣬Ҳ������͵ĺ�Ѫ��
		int rightMin = dfs(rowIndex, colIndex + 1, rowSize, colSize, dungeon);
	//  �±߸��ӵ����Ž�
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
