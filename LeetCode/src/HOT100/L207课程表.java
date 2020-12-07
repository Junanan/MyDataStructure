package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
//给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//
// 
//
//示例 1:
//
//输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
//示例 2:
//
//输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
public class L207课程表 {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[] inDegree = new int[numCourses];
	        List<List<Integer>> adj = new ArrayList<>();
	        for(int i=0;i<numCourses;i++) {
	        	adj.add(new ArrayList<>());
	        }
	        for(int[] a : prerequisites) {
	        	inDegree[a[1]]++;
	        	adj.get(a[1]).add(a[0]);
	        }
	        Queue<Integer> queue = new LinkedList<Integer>();
	        for(int i=0;i<numCourses;i++) {
	        	if(inDegree[i]==0) {
	        		queue.add(i);
	        	}
	        }
	        while(!queue.isEmpty()) {
	        	int temp = queue.poll();
	        	numCourses--;
	        	for(int cur : adj.get(temp)) {
	        		inDegree[cur]--;
	        		if(inDegree[cur]==0) {
	        			queue.add(cur);
	        		}
	        	}
	        }
	        return numCourses==0;
	    }
}
