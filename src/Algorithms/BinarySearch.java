/*
 * This program implements the Binary Search algorithm which runs in O(log n). 
 */

/*
 * The program takes an input n : size of the array.
 * n inputs follow which are the elements of the array
 * Lastly , the program takes a number to be searched as input.
 */

package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static int binarySearch(int list[], int num)
    {
		int size=list.length;
        int lower = 0;
        int upper = size-1;
        int mid = (lower+upper)/2;
        int index = -1;
        while(lower<=upper)
        {
            mid=(lower+upper)/2;
            
            if(list[mid]==num)
            {
                index = mid;
                break;
            }
            else if(list[mid]>num)
            {
                upper = mid-1;
            }
            else
            {
                lower = mid+1;
            }
        }
        return index;
    }
	
	public static void main(String arg[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=scanner.nextInt();
		}
		int search = scanner.nextInt();
		Arrays.sort(ar);
		int index = binarySearch(ar, search);
		if(index == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at position : "+(index+1));
		
	}
}
