import java.util.Arrays;

public class Test {
	 static void partitionArray(int[] arr, int low, int hight) {
		 if(low<hight) {
			int m = partition(arr, low, hight);
				partitionArray(arr, low, m-1);
				partitionArray(arr, m + 1, hight);
		 }
	 }

		 
		 static int partition(int[] arr, int low, int hight) {
			if(low>=hight) return 0;
			int stard = arr[low];
			int i = low;
			int j = hight;
			while (i < j) {
				while (i < j && arr[j] >= stard) {
					j--;
				}
				while (i < j && arr[i] <= stard) {
					i++;
				}
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}	
			arr[low] = arr[i];
			arr[i] = stard;
			return i;
		}
		 public static void main(String[] args) {
			int[] arr =new int [] {4,5,3,2,7,2};
			partitionArray(arr, 0, arr.length-1);
			System.out.println(Arrays.toString(arr));
		}
		 
}
