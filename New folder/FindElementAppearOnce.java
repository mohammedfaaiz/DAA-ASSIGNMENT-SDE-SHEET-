import java.util.ArrayList;
public class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
   
        int result = 0;
        for(Integer num : arr){
            result = result^num;
        }
        return result;
    }
}