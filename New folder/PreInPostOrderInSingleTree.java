/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.*;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if(root==null)
            return result;
        
        BinaryTreeNode<Integer> temp = root;
        getInOrder(temp,inOrder);
        temp = root;
        getPreOrder(temp,preOrder);
        temp = root;
        getPostOrder(temp,postOrder);

        result.add(inOrder);
        result.add(preOrder);
        result.add(postOrder);

        return result;
    }
    public static void getInOrder(BinaryTreeNode<Integer> root,List<Integer> inOrder){
        if(root==null)
            return;
        
        getInOrder(root.left,inOrder);
        inOrder.add(root.data);
        getInOrder(root.right,inOrder);

        return;
    }
    public static void getPreOrder(BinaryTreeNode<Integer> root,List<Integer> preOrder){
        if(root==null)
            return;


        preOrder.add(root.data);
        getPreOrder(root.left,preOrder);
        getPreOrder(root.right,preOrder);

        return;
    }
    public static void getPostOrder(BinaryTreeNode<Integer> root,List<Integer> postOrder){
        if(root==null)
            return;
        
        getPostOrder(root.left,postOrder);
        getPostOrder(root.right,postOrder);
        postOrder.add(root.data);
        
        return;
    }
}