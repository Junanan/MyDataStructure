package HOT100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//�����д���˳���һȺ��վ��һ�����С� ÿ������һ��������(h, k)��ʾ������h������˵���ߣ�k�����������ǰ������ߴ��ڻ����h�������� ��дһ���㷨���ؽ�������С�
//
//ע�⣺
//����������1100�ˡ�
//
//ʾ��
//
//����:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//���:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
public class L406��������ؽ����� {
	//�ߵ����źã����ĺ����
	public int[][] reconstructQueue(int[][] people) {
				Arrays.sort(people,(a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
				List<int []> list = new LinkedList<>();
				for(int[] p : people) {
					list.add(p[1],p);
				}
				int[][] res = new int[list.size()][2];
				int a = 0;
				for(int[] i : list) {
					res[a++] = i;
				}
				return res;
		  }

    }


