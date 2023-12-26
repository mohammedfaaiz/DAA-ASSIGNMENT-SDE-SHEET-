/*************************************************************
    Following is the Binary Tree node structure

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
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		
        int successor = -1;
        int predecessor = -1;
        BinaryTreeNode<Integer> troot = root;
        while(troot!=null){
            if(key>=troot.data)
                troot = troot.right;
            else{
                successor = troot.data;
                troot = troot.left;
            }
        }
        troot = root;
        while(troot!=null){
            if(key<=troot.data)
                troot = troot.left;
            else{
                predecessor = troot.data;
                troot = troot.right;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(predecessor);
        list.add(successor);
        return list;
	}
}