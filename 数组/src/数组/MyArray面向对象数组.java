package 数组;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class MyArray面向对象数组 {
	private int[] elements;// 目标数组用于存储数据的数组

	public MyArray面向对象数组() {
		elements = new int[0];
	}

	// 获取数组长度的方法
	public int size() {
		return elements.length;
	}

	// 往数组的末尾添加一个元素
	public void add(int element) {
		// 创建一个新数组
		int[] newarr = new int[elements.length + 1];
		// 把原数组中的元素复制到新数组中
		for (int i = 0; i < elements.length; i++) {
			newarr[i] = elements[i];
		}
		newarr[elements.length] = element;
		elements = newarr;
		// 打印所有元素到控制台

	}

	public void show() {
		System.out.println(Arrays.toString(elements));
	}

	// 删除数组中的元素
	public void delete(int index) {
		// 判断是否越界
		if (index < 0 || index > elements.length - 1) {
			throw new RuntimeException("下标越界");
		}
		// 创建一个新的数组，长度为原数组的长度-1
		int[] newarr = new int[elements.length - 1];
		for (int i = 0; i < newarr.length; i++) {
			if (i < index) {
				newarr[i] = elements[i];
			} else {
				newarr[i] = elements[i + 1];
			}
		}
		elements = newarr;
	}

	public void deleteaim(int index) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == index) {
				int j = i;
				int[] newarr = new int[elements.length - 1];
				for (int s = 0; s < newarr.length; s++) {
					if (s < j) {
						newarr[s] = elements[s];
					} else {
						newarr[s] = elements[s + 1];
					}
				}
				elements = newarr;
			}
//			}else(elements[i]!=index){
//				System.out.println("不存在此数");
//			}
		}
	}
	//插入一个元素到指定位置
	public void insert(int index,int element) {
		int[] newarr= new int[elements.length+1];
		for(int i=0;i<elements.length;i++) {
			if(i<index) {
				newarr[i]=elements[i];
			}else {
				newarr[i+1]=elements[i];
			}
		}
				newarr[index]=element;
				elements=newarr;
	}
	//替换指定元素
	public void set(int index,int element) {
		// 判断是否越界
				if (index < 0 || index > elements.length - 1) {
					throw new RuntimeException("下标越界");
				}
		elements[index]=element;
	}

}
