/* This program prints all the permutations of a string */
/* The theoretical run time of this algorithm is O( n*n*(n!) ) */

/*
 * The input is a single string whose permutations are to be generated.
 */


package Algorithms;

import java.util.Scanner;

public class PermuteString {
	
	public static void main(String arg[]){
		
		Scanner scanner=new Scanner(System.in);
		
		String string = scanner.nextLine();
		
		permute(string,"");
	}

	private static void permute(String string, String prefix) {
		// TODO Auto-generated method stub
		
		if(string.length()==0)
		{
			System.out.println(prefix);
			return;
		}
		
		for(int i=0 ; i< string.length(); i++)
		{
			String str = string.substring(0,i)+string.substring(i+1);
			permute(str, prefix+string.charAt(i));
		}
		
	}

}
