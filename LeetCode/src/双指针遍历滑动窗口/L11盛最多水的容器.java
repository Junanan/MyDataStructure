package 双指针遍历滑动窗口;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
//垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//说明：你不能倾斜容器，且 n 的值至少为 2。
//示例：
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
public class L11盛最多水的容器 {
	public int maxArea(int[] height) {
		int i =0 ;
		int j = height.length-1;
		int res = 0;
		while(i<j) {
			if(height[i]<=height[j]) {
				res = Math.max(res,height[i]*(j-i));
				i++;
			}else {
				res = Math.max(res, height[j]*(j-i));
				j--;
			}
		}
		return res;
	}
	///移动较小的板 面积可能变小变大不变  移动较大的板 面积就可能不变和变小
}
