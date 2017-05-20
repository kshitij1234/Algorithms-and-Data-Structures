/* This program implements a singly linked list in java with a method */

package DataStructures;

import java.util.Scanner;

class Node{
	
	protected int value;
	protected Node next;
	
	public Node(int value)
	{
		this.value = value;
		this.next = null;
	}
	
	public Node(int value , Node next)
	{
		this.value = value;
		this.next = next;
	}
	
}

class JLinkedList {
	
    protected Node start;
    protected Node end ;
    public int size ;
	
    public JLinkedList() {
		// TODO Auto-generated constructor stub
    	start = null;
        end = null;
        size = 0;
	}
    
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
   
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
        
    
	/* This function takes a time of O(1) here . But remember that if we did not have 
	 * a pointer to the end of the list, we would have iterated through the list taking O(n) time.
	 */
	public void insertAtEnd(int value)
	{
		Node x = new Node(value);
		size++;
		
		if(start==null)
		{
			start = x;
			end = start;
		}
		else
		{
			end.next = x;
			end = x;
		}
	}
	
	/* Take a constant O(1) time */
    public void insertAtStart(int value)
    {
        Node x = new Node(value);    
        size++ ;    

        if(start == null) 
        {
            start = x;
            end = start;
        }
        else 
        {
            x.next=start;
            start = x;
        }
    }
    
    /*  Function to insert an element at position  */
    public void insertAtPos(int value , int pos)
    {
        Node x = new Node(value);                
        Node ptr = start;
        pos = pos - 1 ;

        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.next ;
                ptr.next = x;
                x.next = tmp;
                break;
            }
            ptr = ptr.next;
        }
        size++ ;
    }
    
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.next;
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.next;
            }
            end = t;
            end.next = null;
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.next;
                tmp = tmp.next;
                ptr.next = tmp;
                break;
            }
            ptr = ptr.next;
        }
        size-- ;
    }    

    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }   
        if (start.next == null) 
        {
            System.out.println(start.value);
            return;
        }
        Node ptr = start;
        System.out.print(start.value+ "->");
        ptr = start.next;
        while (ptr.next != null)
        {
            System.out.print(ptr.value+ "->");
            ptr = ptr.next;
        }
        System.out.print(ptr.value+ "\n");
    }

    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        
        JLinkedList list = new JLinkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");            
            int choice = scan.nextInt();            

            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                         
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}
