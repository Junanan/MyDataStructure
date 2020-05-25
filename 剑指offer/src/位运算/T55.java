package λ����;

//��һ������ nums �г�һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε����֡�
//ʾ�� 1��
//
//���룺nums = [3,4,3,3]
//�����4
//ʾ�� 2��
//	
//���룺nums = [9,1,7,9,7,9,7]
//�����1
public class T55 {
	public static int singleNumber(int[] nums) {
		int[] count = new int[32];
		for(int num:nums) {
			for(int j=0;j<32;j++) {
				count[j]+=num&1;
				num>>=1;
			}
		}
		int res=0;
		for(int i=0 ;i<count.length;i++) {
			res<<=1;
			res|=count[31-i]%3;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {3,4,3,3};
		System.out.println(singleNumber(nums));
		int k = (3+4)>>1;
			System.out.println(k);
	}
}
