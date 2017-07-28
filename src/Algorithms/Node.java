package Algorithms;

import java.util.ArrayList;

public class Node 
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