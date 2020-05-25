package 剑指offer;
import BinaryTree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//使用泛型的优点
//Java语言引入泛型的好处是安全简单。泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，提高代码的重用率。
//详细的说：
//类型安全。 泛型的主要目标是提高 Java 程序的类型安全。通过知道使用泛型定义的变量的类型限制，编译器可以在一个高得多的程度上验证类型假设。没有泛型，这些假设就只存在于程序员的头脑中（或者如果幸运的话，还存在于代码注释中）。
//消除强制类型转换。泛型的一个附带好处是，消除源代码中的许多强制类型转换。这使得代码更加可读，并且减少了出错机会。

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//[
//  [3],
//  [9,20], 
//  [15,7]
//]
public class T30 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		//需要3个数据结构
		//①queue 使得节点可以先进先出 还需要for控制queue的长度  达到层遍历   ② TreeNode类的 node 可以获取queue取得节点 在通过他获取当前节点的左右子节点
		//③lins int类的 temp 储存节点的值   ④最后需要()res 储存所有temp;  
		Queue <TreeNode>queue  = new LinkedList<>();//queue<TreeNode> 不加泛型也行
		List<List<Integer>> res = new ArrayList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			for(int i = queue.size();i>0;i--) {
				TreeNode node =  queue.poll();//不加泛型这里需要（TreeNode）强制转换
				temp.add(node.value);
				if(node.leftNode!=null) queue.offer(node.leftNode);
				if(node.rightNode!=null) queue.offer(node.rightNode);
			}
			res.add(temp);
		}
		return res;
    }
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = 	new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		tree.setRoot(root);
		root.setLeftNode(n1);
		root.setRightNode(n2);
		n2.setLeftNode(n3);
		n2.setRightNode(n4);
		List<List<Integer>> a = levelOrder(root);
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		Iterator it =a.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
	}

}
