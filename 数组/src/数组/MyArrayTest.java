package ����;

public class MyArrayTest {
	public static void main(String[] args) {
		//����һ������
		MyArray����������� arr =new MyArray�����������();
		System.out.println(arr.size());
		arr.add(22);
		arr.add(23);
		arr.add(24);
		System.out.println(arr.size());
		arr.deleteaim(24);
		arr.show();
		arr.set(0,2);
		arr.show();
	}

}
