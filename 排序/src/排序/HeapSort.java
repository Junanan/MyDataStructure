package 排序;

/**
 * @author yangjunnan
 * @date 2021/6/9
 */
public class HeapSort {
    class Solution {
        public int[] sortArray(int[] nums) {

            int len = nums.length;
            int[] a = new int[len + 1];

            for (int i = 0; i < nums.length; ++i) {
                a[i + 1] = nums[i];
            }
            //下沉建堆
            for (int i = len / 2; i >= 1; --i) {
                sink(a, i, len);
            }

            int k = len;
            //排序
            while (k > 1) {

                swap(a, 1, k--);
                //每次交换后都需要重新建堆
                sink(a, 1, k);
            }
            for (int i = 1; i < len + 1; ++i) {
                nums[i - 1] = a[i];
            }
            return nums;
        }

        public void sink(int[] nums, int k, int end) {
            //下沉
            while (2 * k <= end) {
                int j = 2 * k;
                //找出子节点中最大或最小的那个
                if (j + 1 <= end && nums[j + 1] > nums[j]) {
                    j++;
                }
                if (nums[j] > nums[k]) {
                    swap(nums, j, k);
                } else {
                    break;
                }
                k = j;
            }
        }

        public void swap(int nums[], int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
}