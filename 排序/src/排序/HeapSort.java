package 排序;

import java.util.Arrays;

/**
 * @author yangjunnan
 * @date 2021/6/9
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(heapSort.sortArray(new int[]{4, 6, 8, 5, 9})));
    }
        public int[] sortArray(int[] nums) {
            heapSort(nums);
            return nums;
        }
        public void heapSort(int[] nums) {
            int len = nums.length - 1;
            //先构建大顶堆
            //从第一个非叶子点开始构建
            for (int i = len / 2; i >= 0; --i) {
                maxHeapify(nums, i, len);
            }
            for (int i = len; i >= 1; --i) {
                //将末尾元素与顶元素交换，也就是交换最大最小值
                swap(nums, i, 0);
                //将剩下的n - 1个元素重新构成大顶堆
                len = len - 1;
                maxHeapify(nums, 0, len);
            }
        }
        //从上至下建最大堆
    public void maxHeapify(int[] nums, int i, int len) {
        while (i * 2 + 1 <= len) {
            //左子节点
            int left = i * 2 + 1;
            //右子节点
            int right = i * 2 + 2;
            int large;
            //如果左子节点大于父节点
            if (left <= len && nums[left] > nums[i]) {
                large = left;
            } else {
                large = i;
            }
            if (right <= len && nums[right] > nums[large]) {
                large = right;
            }
            //子节点大于父节点，交换
            if (large != i) {
                swap(nums, i, large);
                //判断交换后的子节点是否符合
                i = large;
            } else {//可有可无 有的话提前结束 省时
                break;
            }
        }
    }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
