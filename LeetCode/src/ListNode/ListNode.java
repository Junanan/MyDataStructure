package ListNode;


public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}
	 class MyListNode{
		ListNode head = null;
		public MyListNode() {
			 head = new ListNode(0);//初始化头结点  y也可以this.head = head;
		}
	public int get(int index) {
		ListNode cur = head.next;
		int num = -1;////当num = -1链表第一个有值得下标是0 num=0 下标就为1；
		while(cur!=null) {
			num++;
			if(num== index) return cur.val;
			cur = cur.next;
		}
		return -1;
	}
	public void addFirst(int val) {
		ListNode node = new ListNode(val);
		node.next= head.next;
		head.next = node;
	}
	public void addLast(int val) {
	ListNode cur = head;
		while(cur.next!=null) {
		cur = cur.next;
	}
	cur.next = new  ListNode(val);
	}
//	public void addLast(int val) {               
//		ListNode cur = head.next;   head.next 为空 
//			while(cur!=null) {  cur一直为空 会进不去循环
//			cur = cur.next;
//		}
//		cur = new  ListNode(val);
//		}
		
	public void addIndex(int index, int val) {
		ListNode cur = head ;
		int num = -1;
		while(cur!=null) {
			num++;
			if(num==index) {
				ListNode node = new ListNode(val);
				node.next = cur.next;
				cur.next = node;
				break;
			}
			cur = cur.next;
		}
	}
	////使用num = -1 的好处就是替代了查询头结点 所有的下标都是从0开始了
	public void deleteIndex(int index) {
		ListNode cur = head;
		int num =-1;
		while(cur!=null) {
			num++;
			if(num==index) {
				ListNode temp = cur.next;////// cur  temp temp.next 
				cur.next = temp.next;
				break;
			}
			cur = cur.next;
		}
		
	}
	public void show() {
		ListNode currentNode =head.next;
		while(true) {
			System.out.print(currentNode.val+" ");
			currentNode =currentNode.next;
			if(currentNode==null) {
				break;
			}
		}
	}
	
}

