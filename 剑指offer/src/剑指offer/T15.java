package 剑指offer;
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

public class T15 {	
	//递归法  和剑指offer的比较像 而且 简洁
	//x ^ n 转化为 (x * x) ^ n / 2 这是当n 为偶数的情况 奇数还需要 乘一个自身
	public static double Power(double base, int n) {
        if(n == 0) {
            return 1;
        }
        boolean flag = false;
        if(n < 0) {
            flag = true;
            n = -n;
        }
        double res = Power(base * base, n / 2);/////    n/2  达到 分 的效果
        if(n % 2 == 1) {
            res *= base;
        }        
        return flag ? 1 / res : res;
    }
	//////比较难理解
	public  static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;//n∈[−2147483648,2147483647] ，因此当 n = -2147483648n=−2147483648 时执行 n = -n 会因越界而赋值出错。解决方法是先将 n存入 long 变量 b ，后面用 b操作即可。
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

	public static void main(String[] args) {
//		System.out.println(myPow(2, 5));
		System.out.println(Power(2, 5));
	}
}
