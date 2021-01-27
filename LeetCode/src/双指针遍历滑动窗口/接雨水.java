package 双指针遍历滑动窗口;

public class 接雨水 {
    public int trap(int[] height) {
        //找到最大柱子
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <height.length ; i++) {
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        int water = 0;
        //从最大值左边找
        int fastIndex = 0;
        int slowIndex = 0;
        while(fastIndex < maxIndex){
            if(height[slowIndex] > height[fastIndex]){
                water += height[slowIndex] - height[fastIndex];
            }else{
                slowIndex = fastIndex;
            }
            fastIndex++;
        }
        //从最大值右边找
        fastIndex = height.length-1;
        slowIndex = height.length-1;
        while(fastIndex > maxIndex){
            if(height[slowIndex] > height[fastIndex]){
                water += height[slowIndex] - height[fastIndex];
            }else{
                slowIndex = fastIndex;
            }
            fastIndex--;
        }
        return water;
    }

}
