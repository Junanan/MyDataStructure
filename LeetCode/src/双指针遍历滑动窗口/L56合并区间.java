package 双指针遍历滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56合并区间 {
	 public int[][] merge(int[][] intervals) {
		 	List<int[]> res = new ArrayList<>();
	        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
	        int i=0;
	        int len = intervals.length;
	        while(i<len) {
	        	int left=intervals[i][0];
	        	int right=intervals[i][1];
	        	while(i<len-1&&(intervals[i+1][0]<=right)) {
	        		i++;
	        		right = Math.max(right, intervals[i][1]);
	        	}
	        	i++;
	        	int[] temp = new int[] {left,right};
	        	res.add(temp);
	        }
	        return res.toArray(new int[0][]);
	    }
	 
}
