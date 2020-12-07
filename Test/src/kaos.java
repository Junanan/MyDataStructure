
public class kaos {
	public static int find(int[] arr,int n, int key) {
		int a = find(arr,n,key);
		if(arr[a]==key) {
			return a;
		}
		return find(arr,n+1,key);
	}
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4};
		System.out.println(find(a,0,4));
	}
}
