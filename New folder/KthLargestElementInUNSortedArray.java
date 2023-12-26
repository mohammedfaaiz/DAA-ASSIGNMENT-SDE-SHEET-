import java.util.*;
public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0;i<size;i++){
            if(queue.size()>=k && queue.peek()<arr.get(i)){
                queue.poll();
            }
            if(queue.size()!=k)
                queue.offer(arr.get(i));
        }
        
        return queue.peek();
	}
}