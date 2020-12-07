package 数组操作;
import java.util.ArrayList;
import java.util.List;
//给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
//找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
//
//示例:
//
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
public class L448找到所有数组中消失的数字 {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int len = nums.length;
		if(len==0) return new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<len;i++) {
			int num = Math.abs(nums[i])-1;
			nums[num] = -Math.abs(nums[num]);
		}
		for(int i =0 ; i<len;i++) {
			if(nums[i]>0) res.add(i+1); 
		}
		return res;
    }
	public static void main(String[] args) {
		int[] a = new int[] {4,3,2,7,8,2,3,1};
		List<Integer> res = findDisappearedNumbers(a);
		System.out.println(res.get(0));
	}
}

