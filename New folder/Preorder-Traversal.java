/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/
import java.util.*;
public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getOrder(root,list);
        return list;
    }
    public static void getOrder(TreeNode root, List<Integer> list){
        if(root==null)
            return ;

        list.add(root.data);
        getOrder(root.left,list);
        getOrder(root.right,list);
        return ;
    }
}

