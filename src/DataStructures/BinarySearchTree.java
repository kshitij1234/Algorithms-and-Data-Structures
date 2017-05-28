/* A BST is a binary tree i.e. each node can have at most 2 children.
 * Also it has a property that for each node left-child < node < right child
 * Equality sign can be placed either way, depending on the question.
 * Here I will assume that equal key goes as the right child.
 */

package DataStructures;

public class BinarySearchTree {

	TreeNode root;
	
	
	/* 
	 * Implements in-order traversal for BST . Prints elements in ascending order.
	 * Left child -> TreeNode -> Right Child
	 * Time complexity - O(n) where n is the no. of elements
	 */
	public void inOrderTraversal(TreeNode node) {
		
		if(node==null)
			return;
		
		inOrderTraversal(node.getLeft());
		System.out.println(node.getValue());
		inOrderTraversal(node.getRight());
	}
	
	/* 
	 * Implements pre-order traversal for BST .
	 * TreeNode -> Left child -> Right Child
	 * Time complexity - O(n) where n is the no. of elements
	 */
	public void preOrderTraversal(TreeNode node) {
		
		if(node==null)
			return;
		
		System.out.println(node.getValue());
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}
	
	/* 
	 * Implements post-order traversal for BST .
	 * Left child -> Right Child -> TreeNode 
	 * Time complexity - O(n) where n is the no. of elements
	 */
	public void postOrderTraversal(TreeNode node) {
		
		if(node==null)
			return;
		
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		System.out.println(node.getValue());
	}
	
	
	/* Searches the BST for a node with a particular key value and returns
	 * a reference to it. Returns null if no such node exists.
	 * The running time is O(h) where h is the height of the tree.
	 */
	public TreeNode treeSearch(TreeNode node,int value){
		
		if(node==null || node.getValue()==value)
			return node;
		if(value<node.getValue())
		{
			return treeSearch(node.getLeft(), value);
		}
		else
		{
			return treeSearch(node.getRight(), value);
		}
	}
	
	
	
	/*Finds the minimum element of the BST and returns a reference to it
	 *Has a runtime of O(h) where h is the height of the tree. 
	 */
	public TreeNode findMinimum(TreeNode node){
		
		if(node.getLeft()==null)
			return node;
		return findMinimum(node.getLeft());
	}
	
	/*Finds the maximum element of the BST and returns a reference to it
	 *Has a runtime of O(h) where h is the height of the tree. 
	 */
	public TreeNode findMaximum(TreeNode node){
		
		if(node.getRight()==null)
			return node;
		return findMaximum(node.getRight());
	}
	
	
	/* Runtime of O(h) where h is the height of the tree*/
	public TreeNode findSuccessor(TreeNode node){
		
		/*either the leftmost child(minimum) of the right subtree*/
		if(node.getRight()!=null)
			return findMinimum(node.getRight());
		
		/*Or the node in whose left subtree our node lies */
		
		TreeNode parent = node.getParent();
		
		while(parent!=null && node==parent.getRight())
		{
			node = parent;
			parent = parent.getParent();
		}
		return parent;
		
	}
	
	/* Inserts new element into BST. Time - O(h) */
	/* node has parent=right=left=null*/
	public void insert(TreeNode head, TreeNode node){
		
		TreeNode y = null;
		TreeNode x = head;
		
		
		while(x!=null)
		{
			y=x;
			
			if(node.getValue()>=x.getValue())
			{
				x=x.getRight();
			}
			else
			{
				x=x.getLeft();
			}
		}
		
		// y is the parent of node now
		
		node.setParent(y);
		
		if(y==null)
			head = node;
		else if (node.getValue()<y.getValue()) {
			y.setLeft(node);
		}
		else {
			y.setRight(node);
		}
		
	}
	
	/* Replaces u with v in the BST only parent wise. It doesn't change v.left or v.right*/
	public void transplant(TreeNode head , TreeNode u, TreeNode v)
	{
		
		if(u.getParent()==null)
		{
			head = v;
		}
		else if (u==u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		}
		else {
			u.getParent().setRight(v);
		}
		
		if(v!=null)
			v.setParent(u.getParent());
		
		
	}
	public void delete(TreeNode head,TreeNode z)
	{
		// this handles when z has no child or only right child
		if(z.getLeft()==null)
			transplant(head, z, z.getRight());
		else if (z.getRight()==null) {// when z has only left child
			transplant(head, z, z.getLeft());
		}
		else {// z ahs 2 children
			TreeNode yNode = findMinimum(z.getRight());
			if(yNode.getParent()!=z){// ynode is not the right child of z
				transplant(head, yNode, yNode.getRight());
				yNode.setRight(z.getRight());
				yNode.getRight().setParent(yNode);
			}
			transplant(head, z, yNode);
			yNode.setLeft(z.getLeft());
			yNode.getLeft().setParent(yNode);
		}
	}
	
	
}



class TreeNode{
	private int value;
	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the parent
	 */
	public TreeNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	/**
	 * @return the left
	 */
	public TreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode(int value, TreeNode parent, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
}
