package ��ָoffer;

import java.util.HashSet;
import java.util.Set;

//�ҳ��������ظ������֡�
//��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
//
//ʾ�� 1��
//
//���룺
//[2, 3, 1, 0, 2, 5, 3]
//�����2 �� 3 
public class One {
	//���û���ظ����֣���ô�������������iӦ�����±�Ϊi��λ�ã�
	//����˼·����ͷɨ�����飬�����±�Ϊi�������������i�Ļ���������Ϊm),��ô���Ǿ������±�m�����ֽ������ڽ��������У�������ظ������ַ�������ô��ֹ����ture
	 public static int findRepeatNumber(int[] nums) {
		    int temp;
		    for(int i=0;i<nums.length;i++) {
		    	while(nums[i]!=i){
		        if(nums[i]==nums[nums[i]]) {
		        	return nums[i];
		        }
		        temp = nums[i];
		        nums[i] = nums[temp];
		        nums[temp] = temp;
		    	}
	 }
		    return -1;
}
	 /////ʹ�ù�ϣ��ĳ�ͻ
	 public static int findRepeatNumberr(int[] nums) {
		 Set<Integer> set = new HashSet<Integer>();
		 int repeat = -1;
		 for(int i =0;i<nums.length;i++) {
			 if(!set.add(nums[i])) {////ʹ��set.add  �����ڴ��� �򷵻�false
				 repeat = nums[i];
				break;
			 }
		 }
		 return repeat;
		 
	 }
	 public static void main(String[] args) {
			int[] aa = new int[] { 2, 3, 1, 0, 2, 5, 3 };
			System.out.println(findRepeatNumber(aa));
			System.out.println(findRepeatNumberr(aa));
		}
	 
}
