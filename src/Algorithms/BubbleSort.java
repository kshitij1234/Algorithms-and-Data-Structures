/*
 * In bubble sort, we start at the beginning of the array and swap the frst two elements if the frst is greater
 * than the second.Then, we go to the next pair, and so on, continuously making sweeps of the array until it is
 * sorted. In doing so, the smaller items slowly"bubble"up to the beginning of the list.
 */


/*
 * Runtime - O(n^2)
 */

package Algorithms;

import java.util.Scanner;

public class BubbleSort {
	
	// At each full iteration the max element has been pushed to the last of array 
	public static void bubbleSort(int ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar.length-1-i;j++)
			{
				if(ar[j]>ar[j+1])
				{
					int temp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
	}
	
	public static void main(String arg[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ar[] =new int[n];
		for(int i=0;i<n;i++)
			ar[i]=scanner.nextInt();
		
		bubbleSort(ar);
		
		for(int i:ar)
		{
			System.out.print(i+" ");
		}
		
		scanner.close();
	}
	

}
