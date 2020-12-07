package HOT100;

//����һ���������� nums �������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
//
// 
//
//ʾ�� 1:
//
//����: [2,3,-2,4]
//���: 6
//����: ������ [2,3] �����˻� 6��
//ʾ�� 2:
//
//����: [-2,0,-1]
//���: 0
//����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣
public class L152�˻���������� {
	 public int maxProduct(int[] nums) {
		 int len = nums.length;
		 if(len==0) return 0;
		 int ans = nums[0]; //�������Ϊ������������ ����Ҫ��ans ����¼���ֵ
		 int[] max = new int[len];
		 int[] min = new int[len];
		 max[0] = nums[0];
		 min[0] = nums[0];
		 for(int i=1;i<len;i++) {
			 max[i] = Math.max(max[i-1]*nums[i], Math.max(nums[i], min[i-1]*nums[i]));
			 min[i] = Math.min(min[i-1]*nums[i], Math.min(nums[i], max[i-1]*nums[i]));
			 ans = Math.max(ans, max[i]);
		 }
		 return  ans;
		 
	    }
}
