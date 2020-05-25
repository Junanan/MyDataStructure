package 链表;

public class Node {
	// 节点内容
	int data;
	// 下个节点
	Node next;
	public Node(int data) {
		this.data = data;
	}
	// 为节点追回节点
	public Node append(Node node) {
		// 当前节点
		Node currentNode = this;
		// 循环向后找
		while (true) { 
			// 取出下一个节点
			Node nextNode = currentNode.next;
			if (nextNode == null) {
				break;
			}
			// 赋给当前节点
			currentNode = nextNode;
		}
		// 把需要追回的节点追加为找到的当前节点的下一个节点
		currentNode.next = node;
		return this;
	}
	//删除下一个节点                             下面两个有什么区别？？
	public void removeNext() {
		Node newnode = next.next;
		this.next =newnode;
//		this.next=next.next;
	}
	//显示所有节点信息
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
	//当前节点是否为最后一个节点
	public boolean isLast() {
		return next==null;
	}
}
