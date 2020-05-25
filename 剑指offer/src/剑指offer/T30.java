package ��ָoffer;
import BinaryTree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//ʹ�÷��͵��ŵ�
//Java�������뷺�͵ĺô��ǰ�ȫ�򵥡����͵ĺô����ڱ����ʱ�������Ͱ�ȫ���������е�ǿ��ת�������Զ�����ʽ�ģ���ߴ���������ʡ�
//��ϸ��˵��
//���Ͱ�ȫ�� ���͵���ҪĿ������� Java ��������Ͱ�ȫ��ͨ��֪��ʹ�÷��Ͷ���ı������������ƣ�������������һ���ߵö�ĳ̶�����֤���ͼ��衣û�з��ͣ���Щ�����ֻ�����ڳ���Ա��ͷ���У�����������˵Ļ����������ڴ���ע���У���
//����ǿ������ת�������͵�һ�������ô��ǣ�����Դ�����е����ǿ������ת������ʹ�ô�����ӿɶ������Ҽ����˳�����ᡣ

//���ϵ��°����ӡ��������ͬһ��Ľڵ㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�С�
//����:
//����������: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//�������α��������
//[
//  [3],
//  [9,20], 
//  [15,7]
//]
public class T30 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		//��Ҫ3�����ݽṹ
		//��queue ʹ�ýڵ�����Ƚ��ȳ� ����Ҫfor����queue�ĳ���  �ﵽ�����   �� TreeNode��� node ���Ի�ȡqueueȡ�ýڵ� ��ͨ������ȡ��ǰ�ڵ�������ӽڵ�
		//��lins int��� temp ����ڵ��ֵ   �������Ҫ()res ��������temp;  
		Queue <TreeNode>queue  = new LinkedList<>();//queue<TreeNode> ���ӷ���Ҳ��
		List<List<Integer>> res = new ArrayList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			for(int i = queue.size();i>0;i--) {
				TreeNode node =  queue.poll();//���ӷ���������Ҫ��TreeNode��ǿ��ת��
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
