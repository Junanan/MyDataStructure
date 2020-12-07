package Daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
//（这里，平面上两点之间的距离是欧几里德距离。）
//
//你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
//
// 
//
//示例 1：
//
//输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
//示例 2：
//
//输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
public class L973最接近原点的K个点 {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(kClosest(new int[][] {{1,3},{-2,2}},1)));
	}
	public static int[][] kClosest(int[][] points, int K) {
		HashMap<int[],Double> map = new HashMap<>();
		for(int[] arr :points) {
			double temp  =  Math.sqrt(Math.pow(arr[0], 2)+Math.pow(arr[1], 2));
			map.put(arr,temp);
		}
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {			
				return map.get(b).compareTo(map.get(a));
			}
		});
        for(int[] arr: points) {
        	if(queue.size()>=K) {
        		if(map.get(queue.peek())>map.get(arr)) {
        			queue.poll();
        			queue.add(arr);
        		}
        	}else {
        		queue.add(arr);
        	}
        }
        int[][] res = new int[K][2];
        for(int i =0;i<K;i++) {
        	res[i] = queue.poll();
        }
        return res;
        
    }
}
