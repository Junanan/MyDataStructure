package ��ָoffer;

public class ListNode {
	ListNode next;
	int val;
	public ListNode (int x) {
		val = x;
	}
	public ListNode append(ListNode ListNode) {
		// ��ǰ�ڵ�
		ListNode currentNode = this;
		// ѭ�������
		while (true) { 
			// ȡ����һ���ڵ�
			ListNode nextNode = currentNode.next;
			if (nextNode == null) {
				break;
			}
			// ������ǰ�ڵ�
			currentNode = nextNode;
		}
		// ����Ҫ׷�صĽڵ�׷��Ϊ�ҵ��ĵ�ǰ�ڵ����һ���ڵ�
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


