package ����;

public class Node {
	// �ڵ�����
	int data;
	// �¸��ڵ�
	Node next;
	public Node(int data) {
		this.data = data;
	}
	// Ϊ�ڵ�׷�ؽڵ�
	public Node append(Node node) {
		// ��ǰ�ڵ�
		Node currentNode = this;
		// ѭ�������
		while (true) { 
			// ȡ����һ���ڵ�
			Node nextNode = currentNode.next;
			if (nextNode == null) {
				break;
			}
			// ������ǰ�ڵ�
			currentNode = nextNode;
		}
		// ����Ҫ׷�صĽڵ�׷��Ϊ�ҵ��ĵ�ǰ�ڵ����һ���ڵ�
		currentNode.next = node;
		return this;
	}
	//ɾ����һ���ڵ�                             ����������ʲô���𣿣�
	public void removeNext() {
		Node newnode = next.next;
		this.next =newnode;
//		this.next=next.next;
	}
	//��ʾ���нڵ���Ϣ
	public void show() {
		Node currentNode =this;
		while(true) {
			System.out.print(currentNode.getdata()+" ");
			currentNode =currentNode.next;
			if(currentNode==null) {
				break;
			}
		}
	}
	public Node next() {
		return this.next;
	}

	public int getdata() {
		return this.data;
	}
	//��ǰ�ڵ��Ƿ�Ϊ���һ���ڵ�
	public boolean isLast() {
		return next==null;
	}
}
