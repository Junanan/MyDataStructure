package 合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//给出一个区间的集合，请合并所有重叠的区间。
//
//示例 1:
//
//输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2:
//
//输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class L56合并区间 {
	//双指针 找出边界
	public int[][] merge(int[][] intervals) {
			int len = intervals.length;
			List<int[]> res = new ArrayList<int[]>();
		    if (len== 0 || intervals == null) return res.toArray(new int[0][]);
			Arrays.sort(intervals,(a,b)->a[0]-b[0]);   //A<B,按照字符顺序就是升序   A>B,降序     类似compareTo
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
			return res.toArray(new int[0][]	);   // toarray默认返回object类型  int[0][] 中的0为默认用法  如果不传参  就需要强制转换（int[][]） res.toArray
    }
	
	public static void main(String[] args) {
		 List<StringBuilder> rows = new ArrayList<>();
		 for(int i = 0 ;i < 3;i++) {
			 rows.add(new StringBuilder());
		 }
		 System.out.println(rows.size());
		 
	}

}
