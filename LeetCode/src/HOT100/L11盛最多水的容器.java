package HOT100;

public class L11ʢ���ˮ������ {
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
