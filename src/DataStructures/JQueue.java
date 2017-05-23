// This class implements the Queue DS using a Linked List

package DataStructures;

import java.util.Scanner;

public class JQueue {
	
	class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	
	
	
	Node head=null;
	Node tail=null;
	int size=0;
	
	
	public void pop(){
		
		if(size==0)
		{
			System.out.println("Queue is Empty");
			return;
		}
		
		System.out.println("Pop : "+head.value);
		head = head.next;
		size--;
		
	}
	
	public void push(int value)
	{
		Node node = new Node(value);
		node.next=null;
		if(size==0)
		{
			head=node;
			tail=node;
		}
		else {
			tail.next=node;
			tail=node;
		}
		
		size++;
		
	}
	
	public void peek()
	{
		if(size==0)
		{
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Peeked : "+head.value);
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		JQueue jStack = new JQueue();
		
		System.out.println("Option 1 : Push");
		System.out.println("Option 2 : Pop");
		System.out.println("Option 3 : Peek");
		System.out.println("Enter -1 to exit");
		
		while(true)
		{
			System.out.println("Enter choice");
			int c = scanner.nextInt();
			if(c==-1)
				break;
			switch (c) {
			case 1:
				System.out.println("Enter value");
				jStack.push(scanner.nextInt());
				break;
			case 2:jStack.pop();break;
			case 3:jStack.peek();break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
		
		
	}


}
