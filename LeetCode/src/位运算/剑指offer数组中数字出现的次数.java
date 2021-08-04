package λ����;

/**
 * һ���������� nums �����������֮�⣬�������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,1,4,6]
 * �����[1,6] �� [6,1]

 */
public class ��ָoffer���������ֳ��ֵĴ��� {
    public int[] singleNumbers(int[] nums) {
        if(nums.length==0) return new int[]{0};
        int flag=0;;
        for(int i:nums){
            flag^=i;
        }
        int mask=1;
        while((mask&flag)==0){
            mask<<=1;
        }
        int a=0;
        int b=0;
        for(int i:nums){
            if((i&mask)==0){
                a^=i;
            }else{
                b^=i;
            }
        }
        return new int[]{a,b};
    }
}
