package Lab20;


import java.util.Stack;
 
class Node {
 
    int data;
    Node left, right;
 
    public Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
 

public class Inorder {
 
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
 
    public static void main(String args[]) {
         
       
        Inorder tree = new Inorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("In order traversal of binary tree is :");
        tree.inorder();
    }
}