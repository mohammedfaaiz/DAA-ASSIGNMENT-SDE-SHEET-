/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer>  result = new ArrayList<>();
        if(root==null)
            return result;
        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(queue.peek().data);
            while(size-->0){
                TreeNode<Integer> temp = queue.poll();
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
        }
        return result;
    }
}