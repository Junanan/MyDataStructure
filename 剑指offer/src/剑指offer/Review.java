package ½£Ö¸offer;

import java.util.Arrays;

public class Review {
	public double myPow(double x, int n) {
		if(x==0) return 0;
		long b;
		double res=1.0;
		if(n<0) {
			x=1/x;
			b =n;
			b =-b;
		}else {
			while(n>0) {
			if((n & 1)==1) res*=x;
			x*=x;
			n= n>>>1;}
		}
		return res;
    }
	public double myPoww(double x, int n) {
		if(x==0) return 0;
		if(n==0) return 1;
		boolean t=false;
		if(n<0) {
			t=true;
			n=-n;
		}
		double res = myPoww(x*x, n/2);

		if(n%2==1) {
			res=x*res;
		}
		return t?1/res:res;
	}
	public static  void merge(int[]arr,int low,int hight) {
		int mid = (low+hight)/2;
		while(low<hight) {
		merge(arr,low,mid);
		merge(arr,mid+1,hight);
		mergesort(arr,low,mid,hight);
		}
	}
	private static void mergesort(int[] arr, int low, int mid, int hight) {
		int[] tem = new int[hight-low+1];
		int i=low;
		int j=mid+1;
		int index=0;
		while(i<mid&&j<hight) {
		if(arr[i]<arr[j]) {
			i++;
			tem[index]=arr[i];
			index++;
		}else {
			j++;
			tem[index]=arr[j];
			index++;
		}
		}
		while(j<=hight) {
			j++;
			tem[index]=arr[j];
			index++;
		}
		while(i<=mid) {
			i++;
			tem[index]=arr[i];
			index++;
		}
		for(int k=0;k<tem.length;k++) {
			arr[low+k]=tem[k];
		}
		
	}
	public static void main(String[] args) {
		int[] n = new int[] {1,5,78,9,3,4,5};
		 merge(n,0,n.length-1);
		 System.out.println(Arrays.toString(n));
		
	}

}
