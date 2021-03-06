package BFS与DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//每次转换只能改变一个字母。
//转换过程中的中间单词必须是字典中的单词。
//说明:
//
//如果不存在这样的转换序列，返回 0。
//所有单词具有相同的长度。
//所有单词只由小写字母组成。
//字典中不存在重复的单词。
//你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//示例 1:
//
//输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//示例 2:
//
//输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
public class L127单词接龙 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
		Set<String> wordSet = new HashSet<>(wordList);
		if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
			return 0;
		}
		wordSet.remove(beginWord);

		// 图的广度优先遍历，必须使用的队列和表示是否访问过的 visited （数组，哈希表）
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		int wordLen = beginWord.length();
		// 包含起点，因此初始化的时候步数为 1
		int step = 1;
		while (!queue.isEmpty()) {
			int currentSize = queue.size();
			for (int i = 0; i < currentSize; i++) {
				// 依次遍历当前队列中的单词
				String word = queue.poll();
				char[] charArray = word.toCharArray();
				// 修改每一个字符
				for (int j = 0; j < wordLen; j++) {
					// 一轮以后应该重置，否则结果不正确
					char originChar = charArray[j];// 因为要求是改变一个字母 如果不恢复就改变多个了
					for (char k = 'a'; k <= 'z'; k++) {
						if (k == originChar) {
							continue;
						}

						charArray[j] = k;
						String nextWord = String.valueOf(charArray);

						if (wordSet.contains(nextWord)) { // 判断该单词是否在字典里
							if (nextWord.equals(endWord)) { // 判断该单词是否为endword
								return step + 1; //// 此为BFS 层序遍历 与图的最短路径遍历相似 返回的step即为最小路径
							}
							if (!visited.contains(nextWord)) { // 该单词不可重复访问
								queue.add(nextWord); // 遍历完当前单词后 下次从改单词遍历
								// 注意：添加到队列以后，必须马上标记为已经访问
								visited.add(nextWord);
							}
						}
					}
					// 恢复
					charArray[j] = originChar;
				}
			}
			step++;
		}
		return 0;
	}

	public static void main(String[] args) {
//	        String beginWord = "hit";
//	        String endWord = "cog";
//	        List<String> wordList = new ArrayList<>();
//	        String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
//	        Collections.addAll(wordList, wordListArray);
//	        L127单词接龙未 solution = new L127单词接龙未();
//	        int res = solution.ladderLength(beginWord, endWord, wordList);
//	        System.out.println(res);
		HashSet<Integer>[] adj = new HashSet[3];
		for (int i = 0; i < 3; i++) {
			adj[i] = new HashSet<>();
		}
		adj[2].add(1);
		System.out.println(adj[2]);
	}

}