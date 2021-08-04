package 位运算;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]

 */
public class 剑指offer数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        if(nums.length==0) return new int[]{0};
        int flag=0;;
        for(int i:nums){
            flag^=i;
        }
        int mask=1;
        while((mask&flag)==0){
            mask<<=1;
        }
        int a=0;
        int b=0;
        for(int i:nums){
            if((i&mask)==0){
                a^=i;
            }else{
                b^=i;
            }
        }
        return new int[]{a,b};
    }
}
