package Algorithms;

import java.util.Scanner;

import javafx.animation.ParallelTransition;

public class QuickSort {

	
	public static void quickSort(int ar[], int left, int right)
	{
		int index = partition(ar,left,right);
		
		if(left<index-1)
		{
			quickSort(ar, left, index-1);
		}
		if(index<right)
		{
			quickSort(ar, index, right);
		}
	}

	private static int partition(int[] ar, int left, int right) {
		// TODO Auto-generated method stub
		
		int pivot = ar[(left+right)/2];
		
		while(left<=right)
		{
			while(ar[left]<pivot)
				left++;
			while(ar[right]>pivot)
				right--;
			
			if(left<=right)
			{
				int temp=ar[right];
				ar[right]=ar[left];
				ar[left]=temp;
				right--;
				left++;
			}
		}
		
		return left;
		
	}
	
	public static void main(String arg[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ar[] =new int[n];
		for(int i=0;i<n;i++)
			ar[i]=scanner.nextInt();
		
		quickSort(ar, 0, n-1);
		
		for(int i:ar)
		{
			System.out.print(i+" ");
		}
		
		scanner.close();
	}
	
}
