/*
 * Divide and Conquer algorithm.
 * Space - O(n)
 * Time - O(nlogn) all cases.
 */

package Algorithms;

import java.util.Scanner;

public class MergeSort {

	public static void mergeSort(int ar[])
	{
		int helper[] = new int[ar.length];
		
		mergeSort(ar,helper,0,ar.length-1);
		
	}
	
	private static void mergeSort(int ar[], int helper[], int low, int high)
	{
		if(low<high)
		{
			int middle = (low+high)/2;
			mergeSort(ar, helper, low, middle);
			mergeSort(ar, helper, middle+1, high);
			merge(ar,helper,low,middle,high);
		}
	}

	private static void merge(int[] ar, int[] helper, int low, int middle, int high) {
		// TODO Auto-generated method stub
		
		for(int i=low;i<=high;i++)
		{
			helper[i]=ar[i];
		}
		
		int l=low,r=middle+1;
		int current=low;
		while(l<=middle&&r<=high)
		{
			if(helper[l]<helper[r])
			{
				ar[current]=helper[l];
				l++;
			}
			else {
				ar[current]=helper[r];
				r++;
			}
			current++;
		}
		
		int remaining = middle-l;
		for(int i=0;i<=remaining;i++)
		{
			ar[i+current]=helper[i+l];
		}
		
	}
	
	public static void main(String arg[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ar[] =new int[n];
		for(int i=0;i<n;i++)
			ar[i]=scanner.nextInt();
		
		mergeSort(ar);
		
		for(int i:ar)
		{
			System.out.print(i+" ");
		}
		
		scanner.close();
	}
	
}
