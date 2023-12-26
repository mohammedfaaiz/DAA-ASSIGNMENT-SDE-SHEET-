/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/
import java.util.*;
public class Solution {
    static boolean found = false;
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        found = false;
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return null;
        }
        preOrder(root,x,list);
        return list;
    }
    public static void preOrder(TreeNode root,int x,ArrayList<Integer> list){
        if(found || x==root.data){
            list.add(root.data);
            found = true;
            return;
        }
        if(root==null)
            return;
        
        list.add(root.data);
        
        if(!found && root.left!=null){
            preOrder(root.left,x,list);
        }
        if(!found && root.right!=null){
            preOrder(root.right,x,list);
        }
        if(!found){
            list.remove(list.size()-1);
        }
        return;
    }
    
}












