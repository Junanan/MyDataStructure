package ����;

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
            //�ȹ����󶥶�
            //�ӵ�һ����Ҷ�ӵ㿪ʼ����
            for (int i = len / 2; i >= 0; --i) {
                maxHeapify(nums, i, len);
            }
            for (int i = len; i >= 1; --i) {
                //��ĩβԪ���붥Ԫ�ؽ�����Ҳ���ǽ��������Сֵ
                swap(nums, i, 0);
                //��ʣ�µ�n - 1��Ԫ�����¹��ɴ󶥶�
                len = len - 1;
                maxHeapify(nums, 0, len);
            }
        }
        //�������½�����
    public void maxHeapify(int[] nums, int i, int len) {
        while (i * 2 + 1 <= len) {
            //���ӽڵ�
            int left = i * 2 + 1;
            //���ӽڵ�
            int right = i * 2 + 2;
            int large;
            //������ӽڵ���ڸ��ڵ�
            if (left <= len && nums[left] > nums[i]) {
                large = left;
            } else {
                large = i;
            }
            if (right <= len && nums[right] > nums[large]) {
                large = right;
            }
            //�ӽڵ���ڸ��ڵ㣬����
            if (large != i) {
                swap(nums, i, large);
                //�жϽ�������ӽڵ��Ƿ����
                i = large;
            } else {//���п��� �еĻ���ǰ���� ʡʱ
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
