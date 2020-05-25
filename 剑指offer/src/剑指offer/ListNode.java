package 剑指offer;

public class ListNode {
	ListNode next;
	int val;
	public ListNode (int x) {
		val = x;
	}
	public ListNode append(ListNode ListNode) {
		// 当前节点
		ListNode currentNode = this;
		// 循环向后找
		while (true) { 
			// 取出下一个节点
			ListNode nextNode = currentNode.next;
			if (nextNode == null) {
				break;
			}
			// 赋给当前节点
			currentNode = nextNode;
		}
		// 把需要追回的节点追加为找到的当前节点的下一个节点
		currentNode.next = ListNode;
		return this;
	}
	public void show () {
		ListNode cur = this;
		while(cur!=null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
			}
		}
	}
//	public void showw (ListNode a) {
//		while(true) {
//			System.out.print(a.val+"->");
//			a = a.next;
//			if(a==null) {
//				break;
//			}
//		}
//	}


