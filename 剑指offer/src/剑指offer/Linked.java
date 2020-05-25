package ��ָoffer;


public class Linked <T>{
	
	private class Node{
		private T t;
		private Node next;
		public Node(T t,Node next){
			this.t = t;
			this.next = next;
		}
		public Node(T t){
			this(t,null);
		}
	}
	private Node head;    		//ͷ���
	private int size;			//����Ԫ�ظ���
	//���캯��
	public Linked(){
		this.head = null;
		this.size = 0;
	}
	
	//��ȡ����Ԫ�صĸ���
	public int getSize(){
		return this.size;
	}
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty(){
		return this.size == 0;
	}
	//����ͷ�����Ԫ��
	public void addFirst(T t){
		Node node = new Node(t);	//�ڵ����
		node.next = this.head;
		this.head = node;
		this.size++;
		//this.head = new Node(e,head);�ȼ���������
	}
	//������β������Ԫ��
	public void addLast(T t){
		this.add(t, this.size);
	}
	//�������м����Ԫ��
	public void add(T t,int index){
		if (index <0 || index >size){
			throw new IllegalArgumentException("index is error");
		}
		if (index == 0){
			this.addFirst(t);
		}
		Node preNode = this.head;
		//�ҵ�Ҫ����ڵ��ǰһ���ڵ�
		for(int i = 0; i < index-1; i++){
			preNode = preNode.next;
		}
		Node node = new Node(t);
		//Ҫ����Ľڵ����һ���ڵ�ָ��preNode�ڵ����һ���ڵ�
		node.next = preNode.next;
		//preNode����һ���ڵ�ָ��Ҫ����ڵ�node
		preNode.next = node;
		this.size++;
	}
	//ɾ������Ԫ��
	public void remove(T t){
		if(head == null){
			System.out.println("��Ԫ�ؿ�ɾ��");
			return;
		}
		//Ҫɾ����Ԫ����ͷ����Ԫ����ͬ
		while(head != null && head.t.equals(t)){
			head = head.next;
			this.size--;
		}
		/**
		 * �����Ѿ���ͷ�ڵ��б��Ƿ�Ҫ����ɾ��
		 * ����Ҫ��ͷ������һ���������б�
		 */
		Node cur = this.head;
		while(cur.next != null){
			if(cur.next.t.equals(t)){
				this.size--;
				cur.next = cur.next.next;
			}
			else cur = cur.next;
		}
		
	}
	//ɾ�������һ��Ԫ��
	public T removeFirst(){
		if(this.head == null){
			System.out.println("��Ԫ�ؿ�ɾ��");
			return null;
		}
		Node delNode = this.head;
		this.head = this.head.next;
		delNode.next =null;
		this.size--;
		return delNode.t;
	}
	//ɾ����������һ��Ԫ��
	public T removeLast(){
		if(this.head == null){
			System.out.println("��Ԫ�ؿ�ɾ��");
			return null;
		}
		//ֻ��һ��Ԫ��
		if(this.getSize() == 1){
			return this.removeFirst();
		}
		Node cur = this.head;	//��¼��ǰ���
		Node pre = this.head;	//��¼Ҫɾ������ǰһ�����
		while(cur.next != null){
			pre = cur;
			cur = cur.next;
		}
		pre.next = cur.next;
		this.size--;
		return cur.t;
	}
	//�������Ƿ����ĳ��Ԫ��
	public boolean contains(T t){
		Node cur = this.head;
		while(cur != null){
			if(cur.t.equals(t)){
				return true;
			}
			else cur = cur.next;
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node cur = this.head;
		while(cur != null){
			sb.append(cur.t+"->");
			cur = cur.next;
		}
		sb.append("NULL");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Linked<Integer> linked = new Linked();
		for(int i = 0; i < 10; i++){
			linked.addFirst(i);
			System.out.println(linked);
		}
		linked.addLast(33);
		linked.addFirst(33);
		linked.add(33, 5);
		System.out.println(linked);
		linked.remove(33);
		System.out.println(linked);
		System.out.println("ɾ����һ��Ԫ�أ�"+linked.removeFirst());
		System.out.println(linked);
		System.out.println("ɾ�����һ��Ԫ�أ�"+linked.removeLast());
		System.out.println(linked);
	}
}


