

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		if(first==null)
            return second;
        if(second==null)
            return first;
        
        if(first.data>second.data){
            LinkedListNode<Integer> temp = first;
            first = second;
            second = temp;
        }
        
        LinkedListNode<Integer> result = first;
        while(first!=null && second!=null){
            LinkedListNode<Integer> temp = null;
            while(first!=null && first.data<=second.data){
                temp = first;
                first = first.next;
            }
            temp.next = second;
            //swap in order to keep first.data as smallest
            LinkedListNode<Integer> swap = first;
            first = second;
            second = swap;
        }
        return result;
	}
}