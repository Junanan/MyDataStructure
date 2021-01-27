package 双指针遍历滑动窗口;
//大致的思想
//int left = 0, right = 0;
//
//while (right < s.size()) {`
//    // 增大窗口
//    window.add(s[right]);
//    right++;
//
//    while (window needs shrink) {
//        // 缩小窗口
//        window.remove(s[left]);
//        left++;
//    }
//}

// int len = nums.length;
//         if(len==0) return 0;
//         int i = 0;
//         int sum =0;
//         int res = Integer.MAX_VALUE;
//         for(int j =0;j<len;j++) {   //扩张寻找解
//        sum += nums[j];
//        while(sum>=s) {   ///缩小圈优化解
//        res = Math.min(res, j-i+1);
//        sum-=nums[i];
//        i ++;
//        }
//        }
//        return res==Integer.MAX_VALUE?0:res;
//        }
//public static void main(String[] args) {
//        int[] n = new int[] {};
//        minSubArrayLen(100, n);