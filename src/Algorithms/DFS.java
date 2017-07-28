/* Implementation of Depth First Search */

package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
	
	public static void search(Node root)
	{
		if(root==null||root.visited)
			return;
		
		System.out.println(root.name);
		root.visited = true;
		
		for(Node n:root.children)
		{
			if(!n.visited)
			{
				search(n);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of nodes in graph");
		int n = scanner.nextInt();
		
		ArrayList<Node> graph = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			graph.add(new Node(i+1));
		}
		
		System.out.println("Enter the children of each node. -1 to indicate end of input for a node");
		int s=0;
		for(int i=0;i<n;i++)
		{
			while((s=scanner.nextInt())!=-1)
			{
				graph.get(i).children.add(graph.get(s-1));
			}
		}
		
		for(int i=0;i<n;i++)
		search(graph.get(i));
		
		scanner.close();
		
	}
}

class Node 
{
	public int name;
	public boolean visited;
	public ArrayList<Node> children;
	
	public Node(int n)
	{
		name=n;
		visited=false;
		children = new ArrayList<>();
	}
	
}
