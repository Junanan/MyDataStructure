package 位运算;

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//示例 1：
//
//输入：nums = [3,4,3,3]
//输出：4
//示例 2：
//	
//输入：nums = [9,1,7,9,7,9,7]
//输出：1
public class T55 {
	public static int singleNumber(int[] nums) {
		int[] count = new int[32];
		for(int num:nums) {
			for(int j=0;j<32;j++) {
				count[j]+=num&1;
				num>>=1;
			}
		}
		int res=0;
		for(int i=0 ;i<count.length;i++) {
			res<<=1;
			res|=count[31-i]%3;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {3,4,3,3};
		System.out.println(singleNumber(nums));
		int k = (3+4)>>1;
			System.out.println(k);
	}
}
