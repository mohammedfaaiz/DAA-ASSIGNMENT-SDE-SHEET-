/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		ArrayList<Integer> list = new ArrayList<>();
        inOrder(list,root);
        int size = list.size();
        if(size<k)
            return -1;
        return list.get(size-k);
	}
    public static void inOrder(ArrayList<Integer> list,TreeNode<Integer> root){
        if(root==null)
            return;
        
        inOrder(list,root.left);
        list.add(root.data);
        inOrder(list,root.right);
        
        return ;
    }
}






