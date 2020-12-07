package HOT100;

import java.util.HashMap;
import java.util.PriorityQueue;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
//示例:
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true
public class L208实现Trie前缀树 {
	
	class Trie {
		class TrieNode {
			HashMap<Character, TrieNode> next = new HashMap<>();
			boolean isEnd = false;
			}
		TrieNode root = new TrieNode(); 
	    public Trie() {
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	TrieNode cur = root;
	    	for(char i:word.toCharArray()) {
	    		if(cur.next.containsKey(i)) {
	    			cur = cur.next.get(i);
	    		}else {
	    			TrieNode temp = new TrieNode();
	    			cur.next.put(i, temp);
	    			cur = temp;
	    		}
	    	}
	    	cur.isEnd = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	TrieNode cur = root;
	    	for(char i:word.toCharArray()) {
	    		if(cur.next.containsKey(i)) {
	    			cur = cur.next.get(i);
	    		}else {
	    			return false;
	    		}
	    	}
	    	return cur.isEnd;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	TrieNode cur = root;
	    	for(char i:prefix.toCharArray()) {
	    		if(cur.next.containsKey(i)) {
	    			cur = cur.next.get(i);
	    		}else {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}
	 public int findKthLargest(int[] nums, int k) {
	     PriorityQueue<Integer> queue = new PriorityQueue<>();
	     for(int i:nums){
	         if(queue.size()<k){
	             queue.add(i);
	         }else{
	             queue.remove(k-1);
	             queue.add(i);
	         }
	     }
	     int[] res = new int[k];
	     for(int j=0;j<k;j++){
//	         res[j] = queue.;
	     }
	     return res[k-1];
	    }
	 public static void main(String[] args) {
	     PriorityQueue<Integer> queue = new PriorityQueue<>();
	     queue.add(8);
	     queue.add(1);
	     queue.add(4);
	     System.out.println(queue.toString());
	     
	}
}
