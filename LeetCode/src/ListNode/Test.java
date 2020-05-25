package ListNode;

public class Test {
	public static void main(String[] args) {
		MyListNode b = new MyListNode();
		b.addLast(1);
		b.addLast(2);
		b.addLast(3);
		System.out.println(b.get(0));
		b.addIndex(3, 22);
		b.show();
		b.deleteIndex(3);
		System.out.println("===");
		b.show();
	}
	
    
}
