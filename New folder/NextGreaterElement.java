import java.util.*;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		Stack<Integer> stack = new Stack<>();
		for(int i=arr.length-1;i>=0;i--){
            int result = -1;
            while(!stack.isEmpty()){
                if(stack.peek()>arr[i]){
                    result = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(arr[i]);
            arr[i] = result;
        }
        return arr;
	}

}