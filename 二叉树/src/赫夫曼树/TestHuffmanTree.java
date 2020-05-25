package �շ�����;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
	public static void main(String[] args) {
		int[] arr = new int[] {3,7,8,29,5,11,23,14};
		Node node = createHuffmamnTree(arr);
		System.out.println(node);		
		}

	private static Node createHuffmamnTree(int[] arr) {
		//��ʹ�����������е�Ԫ�ش������ɸ�����������ֻ��һ���ڵ㣩
		List<Node> nodes = new ArrayList<>();
		for(int value:arr) {
			nodes.add(new Node(value));
		}
		//ѭ������
		while(nodes.size()>1) {
		//����
		Collections.sort(nodes);
		
		//ȡ����Ȩֵ��С������������
		//ȡ����Ȩֵ��С�Ķ�����
		Node left = nodes.get(nodes.size()-1);
		//ȡ����Ȩֵ��С�Ķ�����
		Node right = nodes.get(nodes.size()-2);
		//����һ���µĶ�����
		Node parent = new Node(left.value+right.value);
		//��ȡ�����������������Ƴ�
		nodes.remove(left);
		nodes.remove(right);
		//����ԭ���Ķ�����������
		nodes.add(parent);
		}
		return nodes.get(0);
}
	}


