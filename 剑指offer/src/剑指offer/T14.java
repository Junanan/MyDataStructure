package 剑指offer;

public class T14 {
//	请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
	 /////普通算法
public static int hammingWeight(int n) {
	int res = 0;
    while(n != 0) {
        res += n & 1;
        n >>>= 1;//无符号右移
    }
    return res;
 }
//////令面试官惊喜的算法
public int hammingWeighty(int n) {
    int res = 0;
    while(n != 0) {
        res++;
        n = n& (n - 1);//1前面的数（0）全部变为1 而1变为0
    }
    return res;
}
public static void main(String[] args) {
	System.out.println(hammingWeight(9));
}
//3.<<(向左位移) 针对二进制，转换成二进制后向左移动3位，后面用0补齐
//
//public static void main(String[] args) {
//         System.out.println("2<<3运算的结果是 :"+(2<<3));
//         //打印的结果是:   2<<3运算的结果是 :16
//     }
//
//4.>>(向右位移) 针对二进制，转换成二进制后向右移动3位，
//
//public static void main(String[] args) {
//         System.out.println("2>>3运算的结果是 :"+(2>>3));
//         //打印的结果是:   2>>3运算的结果是 :0
//     }
//
//5.>>>(无符号右移)  无符号右移，忽略符号位，空位都以0补齐
//
//10进制转二进制的时候，因为二进制数一般分8位、 16位、32位以及64位 表示一个十进制数，所以在转换过程中，最高位会补零。
//
//在计算机中负数采用二进制的补码表示，10进制转为二进制得到的是源码，将源码按位取反得到的是反码，反码加1得到补码
//
//二进制的最高位是符号位，0表示正，1表示负。
//
//>>>与>>唯一的不同是它无论原来的最左边是什么数，统统都用0填充。
//——比如，byte是8位的，-1表示为byte型是11111111(补码表示法）
//b>>>4就是无符号右移4位，即00001111，这样结果就是15。
//下面看代码
//
//public static void main(String[] args) {
//     System.out.println("16>>2运算的结果是 :"+((16)>>2));
//     //打印的结果是:   16>>2运算的结果是 :4
//}
//public static void main(String[] args) {
//         System.out.println("-16>>2运算的结果是 :"+((-16)>>2));
//         //打印的结果是:   -16>>2运算的结果是 :-4
//     }
//
//public static void main(String[] args) {
//         System.out.println("16>>>2运算的结果是 :"+((16)>>>2));
//         //打印的结果是:   16>>>2运算的结果是 :4
//     }
//
//public static void main(String[] args) {
//        System.out.println("-16>>>2运算的结果是 :"+((-16)>>>2));
//        //打印的结果是:   -16>>>2运算的结果是 :1073741820
//     }
}
