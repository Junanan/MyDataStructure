package ���ݷ�;

import java.util.ArrayList;
import java.util.List;

//����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
//
//candidates?�е����ֿ����������ظ���ѡȡ��
//
//˵����
//
//�������֣�����?target��������������
//�⼯���ܰ����ظ�����ϡ�?
//ʾ��?1��
//
//���룺candidates = [2,3,6,7], target = 7,
//����⼯Ϊ��
//[
//  [7],
//  [2,2,3]
//]
//ʾ��?2��
//
//���룺candidates = [2,3,5], target = 8,
//����⼯Ϊ��
//[
//? [2,2,2,2],
//? [2,3,3],
//? [3,5]
//]
public class L39����ܺ� {
    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, list, 0);
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<Integer> list, int j) {
        if (target == sumList(list)) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (sumList(list) > target) {
                break;
            }
            list.add(candidates[i]);
            backtrack(candidates, target, list, i);
            list.remove(list.size() - 1);
        }
    }

    private static int sumList(List<Integer> list) {
        if (list.size() == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
