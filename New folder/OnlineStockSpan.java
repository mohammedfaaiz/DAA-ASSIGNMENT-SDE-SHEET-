import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<price.size();i++){
            if(!stack.isEmpty() && stack.peek().value<=price.get(i)){
                while(!stack.isEmpty() && stack.peek().value<=price.get(i))
                    stack.pop();
            }
            if(stack.isEmpty())
                result.add(i+1);
            else
                result.add(i-stack.peek().index);
            stack.push(new Pair(i,price.get(i)));
        }
        return result;
    }
}
class Pair{
    int index;
    int value;
    Pair(int i,int v){
        index = i;
        value = v;
    }
}