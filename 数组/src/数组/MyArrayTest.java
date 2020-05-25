package 数组;

public class MyArrayTest {
	public static void main(String[] args) {
		//创建一个数组
		MyArray面向对象数组 arr =new MyArray面向对象数组();
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
