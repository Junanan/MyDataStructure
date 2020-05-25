package 数组;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		//创建一个数组
	    int[] arr1 = new int[] {7,8,9};
	    //获取数组长度
	    int length1 = arr1.length;
	    System.out.println("arr1的长度"+arr1.length);
	    //访问数组中的元素：数组名[下标] 注意下标从0开始，最大可以取到长度-1
	    int elemengt0 = arr1[0];
	    //要加入数组的目标元素
	    int dst=6;
	    
	    //添加元素
	    //创建一个新的数组，长度是原数组长度+1
	    int[] newarr = new int[arr1.length+1];
	    //把原数组中的数据全部复制到型数组中
	    for(int i=0;i<arr1.length;i++) {
	    	newarr[i]=arr1[i];
	    }
	    //把目标元素放入新数组的最后
	    newarr[newarr.length-1]=dst;
	    //新数组替换原数组
	    arr1=newarr;
	    System.out.println(Arrays.toString(arr1));
	    //删除元素的下标
	    int ds =1;
	    //删除元素
	    //创建一个新的数组，长度是原数组长度-1
	    int[] newArr = new int[arr1.length-1];
	    //复制原数组中除了要删除的那个元素以外其他的元素
	    for(int i=0;i<newArr.length;i++) {
	    	if(i<ds) {
	    		newArr[i]=arr1[i];
	    	}else {
	    		newArr[i]=arr1[i+1];
	    	}
	    }
	    arr1=newArr;
	    System.out.println(Arrays.toString(arr1));
	}

}
