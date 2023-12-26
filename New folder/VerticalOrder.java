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
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        
        if(root==null)
            return result;
        
        Pair rt = new Pair(root,0);
        queue.offer(rt);
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            if(map.containsKey(temp.index)){
                map.get(temp.index).add(temp.node.data);
            }
            else{
                map.put(temp.index,new ArrayList<>());
                map.get(temp.index).add(temp.node.data);
            }

            
            if(temp.node.left!=null)
                queue.offer(new Pair(temp.node.left,temp.index-1));
            if(temp.node.right!=null)
                queue.offer(new Pair(temp.node.right,temp.index+1));
        }
        
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            result.addAll(entry.getValue());
        }
        
        return result;
    }
}
class Pair{
    TreeNode<Integer> node;
    int index;
    Pair(TreeNode<Integer> node,int i){
        this.node = node;
        index= i;
    }
}







