/*
 * Time - O(n^2) worst case . O(n) best case.
 * In place sorting
 */


package Algorithms;

import java.util.Scanner;

public class InsertionSort {
	
	
	public static void insertionSort(int ar[])
	{
		for(int i=1;i<ar.length;i++)
		{
			int temp = ar[i];
			int hole = i;
			
			while(hole>0&&ar[hole-1]>temp)
			{
				ar[hole] = ar[hole-1];
				hole--;
			}
			
			ar[hole] = temp;
		}
	}


	public static void main(String arg[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ar[] =new int[n];
		for(int i=0;i<n;i++)
			ar[i]=scanner.nextInt();
		
		insertionSort(ar);
		
		for(int i:ar)
		{
			System.out.print(i+" ");
		}
		
		scanner.close();
	}
	

}
