package 剑指offer;

import java.util.Arrays;

public class Night {
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
//输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
//示例 1：
//输入：[3,4,5,1,2]
//输出：1
//示例 2：
//输入：[2,2,2,0,1]
//输出：0
	
	
	/////类似二分查找  代码比剑指offer简洁 但是不好理解
	public static int minArray(int[] numbers) {
		int len = numbers.length;
		int i = 0, j = len - 1;
		while (i < j) {
			int mid = (i + j) / 2;
			if (numbers[mid] > numbers[j]) {
				i = mid + 1;
			} else if (numbers[mid] < numbers[j]) {
				j = mid;
			} else
				j--;
		}
		return numbers[i];
	}
//	当 numbers[m] > numbers[j]时： m一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1；
//			当 numbers[m] < numbers[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m；
//			当 numbers[m] == numbers[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [i, m] 还是 [m + 1, j] 区间中。
//			解决方案： 执行 j = j - 1  缩小判断范围 （分析见以下内容） 。
	////  如果m在右排序 [m,j] 范围都是重复数值 j=j-1 只会删除重复数值缩小范围  旋转点X还是在[i,j]
	////  如果m在左排序    由左排序任意数值>=右排序数值 ①当num[x] < num[j]  说明j左方还有更小的数值 j= j-1 缩小范围
	////  ② num[x] = num[j]  j= j-1 可能会丢失最小值的索引例如 [1, 1, 1, 2, 3, 1]但最终返回值仍正确（最终返回的 numbers[0] 等于旋转点值 numbers[5] ）
	
	///剑指offer的代码
	public int minArrayy(int[] numbers) {
	        int l = 0, r = numbers.length - 1;
	        int mid = l;
	        while (numbers[l] >= numbers[r]) {
	            if (r - l == 1) {
	                mid = r;
	                break;
	            }
	            mid = (l + r) / 2;
	            if (numbers[l] == numbers[r] && numbers[l] == numbers[mid])
	                return minInOrder(numbers, l, r);
	            if (numbers[mid] >= numbers[l]) {
	                l = mid;
	            } else if (numbers[mid] <= numbers[r]) {
	                r = mid;
	            }
	        }
	        return numbers[mid];
	    }

	    private int minInOrder(int[] number, int l, int r){
	        int result = number[l];
	        for (int i = l + 1; i < r; i++) {
	            if (result > number[i]){
	                result = number[i];
	            }
	        }
	        return result;
	    }
	public static void main(String[] args) {
		int[] a = { 2, 2, 2, 3, 4, 5, 2 };
		System.out.println(Arrays.toString(a));
		System.out.println(minArray(a));
	}
}
