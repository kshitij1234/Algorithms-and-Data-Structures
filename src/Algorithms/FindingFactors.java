

/* This Algorithm finds out the factors of a number in O( n^.5 ) */

package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindingFactors {
	
	public static void main(String arg[]){
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> factors = new ArrayList<>();
		
		for(int i=1 ; i<= Math.sqrt(n); i++)
		{
			int a = n%i;
			if(a==0)
			{
				factors.add(i);
				if(i!=Math.sqrt(n))
				{
					factors.add(n/i);
				}
			}
		}
		Collections.sort(factors);
		
		for(int x : factors)
		{
			System.out.print(x+" ");
		}
	}

}
