package ½£Ö¸offer;

import java.util.*;

public class T1 {
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < length; i++) {
			if (set.contains(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				set.add(numbers[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] aa = new int[] { 2, 3, 1, 0, 2, 5, 3 };
		int[] s = new int[] { 0 };
		System.out.println(duplicate(aa, 7, s));
	}

}
