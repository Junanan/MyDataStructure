package 剑指offer;
//数字以0123456789101112131415…的格式序列化到一个字符序列中。
//在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//请写一个函数，求任意第n位对应的数字。
//示例 1：
//输入：n = 3
//输出：3
//示例 2：
//输入：n = 11
//输出：0
public class T41 {
	public static int findNthDigit(int n) {
	      if (n <= 9)
	            return n;
	        n--;//下标从0开始
	        int i = 1;// 位数
	        long first = 1; // 当前范围内第一个数， 注意越界。
	        //弄清有多少位
	        while (n > 9 * first * i){
	            n -= 9 * first * i;   // 让n在循环结束后表示当前范围的第n位数字
	            i++;
	            first *= 10;
	        }
	        int a = String.valueOf(first + n / i).charAt(n % i) - '0';//n%i 对应数字的第几位    //注意- '0'因为是string
	        return a;
    }
//	到规律 0~9有10个数字，10~99有90个数字，100~999有900个数字
	public static void main(String[] args) {
		System.out.println(findNthDigit(456));
	}

}
