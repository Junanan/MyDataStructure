package HOT100;

import java.util.HashMap;

import javax.activation.MailcapCommandMap;

//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
//
//����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
//
//
//
//ʾ��:
//	
//	���� nums = [2, 7, 11, 15], target = 9
//	
//	��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//	���Է��� [0, 1]
public class L1����֮�� {
	public static int[] twoSum(int[] nums, int target) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int[] res = new int[2];
			for(int i=0;i<nums.length;i++) {
				map.put(nums[i], i);
			}
			for(int i=0;i<nums.length;i++) {
				if(map.containsKey(target-nums[i])&&(map.get(target-nums[i])!=i)) {
					res[0] =i;
					res[1] = map.get(target-nums[i]);
					break;
				}
			}
			return res;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,4};
		System.out.println(twoSum(nums,6));
	}
}
