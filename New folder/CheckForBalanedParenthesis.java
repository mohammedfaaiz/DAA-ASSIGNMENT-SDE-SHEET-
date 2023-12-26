import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c : expression.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if(c==')' && stack.peek()=='('){
                    stack.pop();
                }
                else if(c==']' && stack.peek()=='['){
                    stack.pop();
                }
                else if(c=='}' && stack.peek()=='{'){
                    stack.pop();
                }
                else return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}