/* 
 * Implementation of the sieve of eratosthenes algorithm 
 * to find the prime numbers upto n.
 * The time complexity is O( n*log(log n))
 */


/*
 * Input is a single integer n upto which the prime numbers are to be generated.
 */
package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class SieveOfEratosthenes {
	
	public static ArrayList<Integer> sieve(int a) {
	    
	    int ar[]=new int[a+1];
	    
	    //assume all numbers from 0 to n are prime
	    for(int i=0;i<=a;i++)
	    	ar[i]=1;
	    
	    ar[0]=ar[1]=0;
	    
	    for(int i=2;i<=Math.sqrt(a);i++)
	    {
	        if(ar[i]==1)
	        {
	        	//multiples of prime numbers are not prime
	            for(int j=2;i*j<=a;j++)
	            {
	                ar[i*j]=0;
	            }
	        }
	    }
	    
	    ArrayList<Integer> prime=new ArrayList<>();
	    for(int i=0;i<=a;i++)
	    {
	        if(ar[i]==1)
	        prime.add(i);
	    }
	    return prime;
	    
	}
	
	public static void main(String arg[]){
		
		Scanner scanner = new Scanner(System.in);
		
		int n=scanner.nextInt();
		
		ArrayList<Integer> primes = sieve(n);
		
		for(int i:primes)
		{
			System.out.print(i+" ");
		}
		
		
	}
	
}
