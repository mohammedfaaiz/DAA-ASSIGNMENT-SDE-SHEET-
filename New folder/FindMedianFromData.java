
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void findMedian(int arr[])  {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    return -1*a.compareTo(b);
                }
            }
        );
        
        for(int ar : arr){
            add(minHeap,maxHeap,ar);
            balance(minHeap,maxHeap);
            int result = getMedian(minHeap,maxHeap);
            System.out.print(result+" ");
        }
    }
    public static void add(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap,int num){
        if(minHeap.size()==0 || minHeap.peek()>num){
            minHeap.offer(num);
        }
        else{
            maxHeap.offer(num);
        }
    }

    public static void balance(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap){
        PriorityQueue<Integer> mostElement = minHeap.size()>maxHeap.size()?minHeap:maxHeap;
        PriorityQueue<Integer> lessElement = minHeap.size()>maxHeap.size()?maxHeap:minHeap;
        
        if(mostElement.size()-lessElement.size()>=2){
            lessElement.offer(mostElement.poll());
        }
    }
    
    public static int getMedian(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap){
        PriorityQueue<Integer> mostElement = minHeap.size()>maxHeap.size()?minHeap:maxHeap;
        PriorityQueue<Integer> lessElement = minHeap.size()>maxHeap.size()?maxHeap:minHeap;
        
        if(mostElement.size()==lessElement.size()){
            return (mostElement.peek()+lessElement.peek())/2;
        }
        else{
            return mostElement.peek();
        }
    } 

}





