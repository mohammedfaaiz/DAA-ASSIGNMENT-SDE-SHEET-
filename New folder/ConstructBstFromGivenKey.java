/****************************************************************

    Following is the class structure of the TreeNode class:

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


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return fn(arr,0,n-1);
    }
    public static TreeNode<Integer> fn(ArrayList<Integer> arr, int start, int end){
        if(start>end)
            return null;
        
        int mid = start+(end-start)/2;
        TreeNode<Integer> node = new TreeNode<Integer>(arr.get(mid));
        
        if(start==end)
            return node;
        
        node.left = fn(arr,start,mid-1);
        node.right = fn(arr,mid+1,end);
        
        return node;        
    }
}














