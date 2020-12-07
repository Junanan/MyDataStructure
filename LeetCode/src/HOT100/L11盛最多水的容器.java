package HOT100;

public class L11盛最多水的容器 {
	public int maxArea(int[] height) {
		int i =0;
		int j =height.length-1;
		int max = 0;
		while(i<j) {
			if(height[i]<height[j]) {
			max = Math.max(max, (j-i)*height[i]);
			i++;
			}else {
				max = Math.max(max, (j-i)*height[j]);
			j--;
			}
		}
		return max;
    }
}
