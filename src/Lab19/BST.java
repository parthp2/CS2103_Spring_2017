package Lab19;

import java.util.Stack;


public class BST {
	
	class Node {
		 
	    int data;
	    Node left, right;
	 
	    public Node(int item) 
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	public static void main(String[] args) {
		

	}
	
	public void breadthFirstTraversal()
	{

		Node root;
		 
	    void inorder()
	    {
	        if (root == null) 
	        {
	            return;
	        }
	        
	        
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	         
	        
	        while (node != null) 
	        {
	            stack.push(node);
	            node = node.left;
	        }
	         
	        
	        while (stack.size() > 0) 
	        {
	           
	           
	            node = stack.pop();
	            System.out.print(node.data + " ");
	            if (node.right != null)
	            {
	                node = node.right;
	                
	                while (node != null) 
	                {
	                    stack.push(node);
	                    node = node.left;
	                }
	            }
	        }
		
	    }
	}

	public int height()
	{

		

	 return the height of tree;

	}
	public int getNumberOfLeaves()
	{

		

		return 0;

	}
	
	public int getNumberOfNonLeaves()
	{

		

		return 0;

	}
}
