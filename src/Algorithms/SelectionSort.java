/*
 * Selection sort is the child's algorithm: simple, but inefcient. Find the smallest element using a linear scan
 * and move it to the front (swapping it with the front element). Then, fnd the second smallest and move it,
 * again doing a linear scan. Continue doing this until all the elements are in place.
 */

/*
 * Runtime - O(n^2) . Memory - O(1)
 */

package Algorithms;

import java.util.Scanner;

public class SelectionSort {
	
	public static void selectionSort(int ar[])
	{
		int min,pos;
		
		for(int i=0;i<ar.length;i++)
		{
			min = ar[i];
			pos = i;
			for(int j=i+1;j<ar.length;j++)
			{
				if(ar[j]<min)
				{
					min = ar[j];
					pos = j;
				}
			}
			
			int temp = ar[i];
			ar[i] = ar[pos];
			ar[pos] = temp;
		}
	}

	public static void main(String arg[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ar[] =new int[n];
		for(int i=0;i<n;i++)
			ar[i]=scanner.nextInt();
		
		selectionSort(ar);
		
		for(int i:ar)
		{
			System.out.print(i+" ");
		}
		
		scanner.close();
	}
}
