
import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        
		Stack<Integer> extra = new Stack<>();
        int max = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            if(max<stack.peek()){
                if(max!=Integer.MIN_VALUE)
                    extra.push(max);
                max = stack.pop();
            }
            else{
                extra.push(stack.pop());
            }
        }
        while(!extra.isEmpty()){
            stack.push(extra.pop());
        }
        
        sortStack(stack);
        stack.push(max);
        return ;
	}

}