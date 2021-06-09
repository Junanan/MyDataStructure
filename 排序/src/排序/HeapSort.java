package ����;

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
            //�³�����
            for (int i = len / 2; i >= 1; --i) {
                sink(a, i, len);
            }

            int k = len;
            //����
            while (k > 1) {

                swap(a, 1, k--);
                //ÿ�ν�������Ҫ���½���
                sink(a, 1, k);
            }
            for (int i = 1; i < len + 1; ++i) {
                nums[i - 1] = a[i];
            }
            return nums;
        }

        public void sink(int[] nums, int k, int end) {
            //�³�
            while (2 * k <= end) {
                int j = 2 * k;
                //�ҳ��ӽڵ���������С���Ǹ�
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