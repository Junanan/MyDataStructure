package ��ָoffer;
//������0123456789101112131415���ĸ�ʽ���л���һ���ַ������С�
//����������У���5λ�����±�0��ʼ��������5����13λ��1����19λ��4���ȵȡ�
//��дһ���������������nλ��Ӧ�����֡�
//ʾ�� 1��
//���룺n = 3
//�����3
//ʾ�� 2��
//���룺n = 11
//�����0
public class T41 {
	public static int findNthDigit(int n) {
	      if (n <= 9)
	            return n;
	        n--;//�±��0��ʼ
	        int i = 1;// λ��
	        long first = 1; // ��ǰ��Χ�ڵ�һ������ ע��Խ�硣
	        //Ū���ж���λ
	        while (n > 9 * first * i){
	            n -= 9 * first * i;   // ��n��ѭ���������ʾ��ǰ��Χ�ĵ�nλ����
	            i++;
	            first *= 10;
	        }
	        int a = String.valueOf(first + n / i).charAt(n % i) - '0';//n%i ��Ӧ���ֵĵڼ�λ    //ע��- '0'��Ϊ��string
	        return a;
    }
//	������ 0~9��10�����֣�10~99��90�����֣�100~999��900������
	public static void main(String[] args) {
		System.out.println(findNthDigit(456));
	}

}
