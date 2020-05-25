package Á´±í;

public class Test {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.append(n2).append(n3);
//		System.out.println(n1.getdata());
//		System.out.println(n1.next().getdata());
//		System.out.println(n3.isLast());
		n1.next.removeNext();
		n1.show();
	}
}
