package BFS与DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//你这个学期必须选修 numCourse 门课程，记为?0?到?numCourse-1 。
//
//在选修某些课程之前需要一些先修课程。?例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
//给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//
//示例 1:
//
//输入: 2, [[1,0]] 
//输出: true
//解释:?总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
//示例 2:
//
//输入: 2, [[1,0],[0,1]]
//输出: false
//解释:?总共有 2 门课程。学习课程 1 之前，你需要先完成?课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
public class L207课程表 {
	public static boolean  canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses<=0) return false;
		int len = prerequisites.length;
		if(len==0) return true;
		List<List<Integer>> adj = new ArrayList<>(); // adjacency   储存邻接的关系 
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0;i<numCourses;i++) {
			adj.add(new ArrayList<>());
		}
		int[] inDegrees = new int[numCourses];                     //  [ [3, 0], [3, 1], [4, 1], [4, 2], [5, 3], [5, 4] ]
		for(int[] cp : prerequisites) {                            //   0 
			inDegrees[cp[0]]++;                                    //    ↘
			adj.get(cp[1]).add(cp[0]);                             //    ↗     3   
		}                                                          //	1            ↘
		for(int i = 0 ;i<numCourses ; i++) {					   //    ↘       ↗    5
			if(inDegrees[i]==0) queue.add(i);                      //   ↗     4
		}                                                          //  2 
			while(!queue.isEmpty()) {							     
				int pre = queue.poll();											
				numCourses--;   //会影响for
				for(int cur : adj.get(pre)) {  //将 pre 指向的节点 遍历一遍
					inDegrees[cur]--;
					if(inDegrees[cur]==0) queue.add(cur);
				}
			}
		return numCourses==0;
    }
	public static void main(String[] args) {
		int[][] a = new int[][] {{1,0}};
		canFinish(2,a);
	}
//	复杂度分析：
//
//	时间复杂度：O(E + V)。这里 EE 表示邻边的条数，V 表示结点的个数。初始化入度为 0的集合需要遍历整张图，具体做法是检查每个结点和每条边，
	//因此复杂度为 O(E+V)，然后对该集合进行操作，又需要遍历整张图中的每个结点和每条边，复杂度也为 O(E+V)；
//	空间复杂度：O(E + V)：邻接表长度是 V，每个课程里又保存了它所有的边。
}
//一起审题
//一共有 n 门课要上，编号为 0 ~ n-1
//先决条件 [1, 0]，代表必须先上课 0 ，才能上课 1
//给你 n 和 一个先决条件表，请你判断能否完成所有课程
//
//把这样一个 有向无环图 变成 线性的排序 就叫 拓扑排序
//有向图 中有 入度 和 出度 概念：
//如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度
//所以 0、1、2 的 入度为 0。 而 3、4、5 的 入度为 2
//
//不能“跳步”，选你能上的课
//选课只能选 入度为 0 的课，因为它不依赖别的课
//假设选了 0，导致 依赖 0 的课的入度减小——课 3 的入度由 2 变 1
//接着选 1，导致课 3 的入度变 0，课 4 的入度由 2 变 1
//接着选 2，导致课 4 的入度变 0，当前 3 和 4 入度为 0
//继续选 入度为 0 的课 …… 直到选不到 入度为 0 的课
//
//这形似 树的BFS
//起初让 入度为 0 的课 入列
//然后逐个出列，课出列 即 课被选 ，并 减小相关课的入度
//判定是否有 入度新变为 0 的课，安排入列、再出列……
//直到没有 入度为 0 的课 可入列……
//
//BFS 前的准备工作
//我们关心 课的入度—— 该值要被减，要被监控
//我们关心 课之间的依赖关系 —— 选这门课会减小哪些课的入度
//因此我们需要合适的数据结构，去存储这些关系
//
//入度数组 和 邻接表
//课的编号是 0 到 n - 1，让它作为索引，值为课的入度。通过遍历先决条件表，计算出每门课的初始入度
//用哈希表记录 依赖关系 （也可以用 邻接矩阵 ，但它有点大）
//key： 课的编号
//value： 依赖它的后续课程
