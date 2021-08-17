package Daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//����һ����������?arr?�����㽫�����е�Ԫ�ذ���������Ʊ�ʾ������ 1 ����Ŀ��������
//
//������ڶ�����ֶ�������?1?����Ŀ��ͬ������뽫���ǰ�����ֵ��С�������С�
//
//���㷵�����������顣
//
//?
//
//ʾ�� 1��
//
//���룺arr = [0,1,2,3,4,5,6,7,8]
//�����[0,1,2,4,8,3,5,6,7]
//���ͣ�[0] ��Ψһһ���� 0 �� 1 ������
//[1,2,4,8] ���� 1 �� 1 ��
//[3,5,6] �� 2 �� 1 ��
//[7] �� 3 �� 1 ��
//���� 1 �ĸ�������õ��Ľ������Ϊ [0,1,2,4,8,3,5,6,7]
public class L1356�������ֶ�������1����Ŀ���� {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1})));
	}
	public static int[] sortByBits(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		for (int i : arr) {
			int count = getCount(i);
			map.put(i, count);
			list.add(i);
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				 if (map.get(o1) != map.get(o2)) {
	                    return map.get(o1) - map.get(o2);
	                } else {
	                    return o1 - o2;
	                }
			}
		});;
		int k = 0;
		for (int i : list) {
			arr[k++] = i;
		}
		return arr;
	}

	private static int getCount(int i) {
		int count = 0;
		while (i != 0) {
			if ((i & 1) == 1) {
				count ++;
				i >>= 1;
			}else {
				i >>= 1;
			}
		}
		return count;
	}
}
