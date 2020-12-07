package �ϲ�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//����һ������ļ��ϣ���ϲ������ص������䡣
//
//ʾ�� 1:
//
//����: [[1,3],[2,6],[8,10],[15,18]]
//���: [[1,6],[8,10],[15,18]]
//����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
//ʾ�� 2:
//
//����: [[1,4],[4,5]]
//���: [[1,5]]
//����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
public class L56�ϲ����� {
	//˫ָ�� �ҳ��߽�
	public int[][] merge(int[][] intervals) {
			int len = intervals.length;
			List<int[]> res = new ArrayList<int[]>();
		    if (len== 0 || intervals == null) return res.toArray(new int[0][]);
			Arrays.sort(intervals,(a,b)->a[0]-b[0]);   //A<B,�����ַ�˳���������   A>B,����     ����compareTo
			int i =0;
			while(i<len) {
				int left = intervals[i][0];
				int right = intervals[i][1];
				while(i<len-1&&intervals[i+1][0]<=right) {
					i++;
					right = Math.max(right,intervals[i][1] );
				}
				i++;
				res.add(new int[] {left,right});
			}
			return res.toArray(new int[0][]	);   // toarrayĬ�Ϸ���object����  int[0][] �е�0ΪĬ���÷�  ���������  ����Ҫǿ��ת����int[][]�� res.toArray
    }
	
	public static void main(String[] args) {
		 List<StringBuilder> rows = new ArrayList<>();
		 for(int i = 0 ;i < 3;i++) {
			 rows.add(new StringBuilder());
		 }
		 System.out.println(rows.size());
		 
	}

}
