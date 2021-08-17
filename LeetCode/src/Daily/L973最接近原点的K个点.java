package Daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//������һ����ƽ���ϵĵ���ɵ��б� points����Ҫ�����ҳ� K ������ԭ�� (0, 0) ����ĵ㡣
//
//�����ƽ��������֮��ľ�����ŷ����¾��롣��
//
//����԰��κ�˳�򷵻ش𰸡����˵������˳��֮�⣬��ȷ����Ψһ�ġ�
//
//?
//
//ʾ�� 1��
//
//���룺points = [[1,3],[-2,2]], K = 1
//�����[[-2,2]]
//���ͣ� 
//(1, 3) ��ԭ��֮��ľ���Ϊ sqrt(10)��
//(-2, 2) ��ԭ��֮��ľ���Ϊ sqrt(8)��
//���� sqrt(8) < sqrt(10)��(-2, 2) ��ԭ�������
//����ֻ��Ҫ����ԭ������� K = 1 ���㣬���Դ𰸾��� [[-2,2]]��
//ʾ�� 2��
//
//���룺points = [[3,3],[5,-1],[-2,4]], K = 2
//�����[[3,3],[-2,4]]
//���� [[-2,4],[3,3]] Ҳ�ᱻ���ܡ���
public class L973��ӽ�ԭ���K���� {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(kClosest(new int[][] {{1,3},{-2,2}},1)));
	}
	public static int[][] kClosest(int[][] points, int K) {
		HashMap<int[],Double> map = new HashMap<>();
		for(int[] arr :points) {
			double temp  =  Math.sqrt(Math.pow(arr[0], 2)+Math.pow(arr[1], 2));
			map.put(arr,temp);
		}
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {			
				return map.get(b).compareTo(map.get(a));
			}
		});
        for(int[] arr: points) {
        	if(queue.size()>=K) {
        		if(map.get(queue.peek())>map.get(arr)) {
        			queue.poll();
        			queue.add(arr);
        		}
        	}else {
        		queue.add(arr);
        	}
        }
        int[][] res = new int[K][2];
        for(int i =0;i<K;i++) {
        	res[i] = queue.poll();
        }
        return res;
        
    }
}
