import java.util.*;
public class Solution {
    static int time = 0;
    
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        time = 0;
        int[] lowTime = new int[n];
        int[] startTime = new int[n];
        Arrays.fill(startTime,-1);
        boolean[] onStack = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        //create adjList 
        initializeList(adjList,n);
        createAdjList(adjList,n,edges);
        
        //lets do this
        for(int i=0;i<n;i++){
            if(startTime[i]==-1){
                dfs(startTime,onStack,stack,result,adjList,lowTime,i);
            }
        }
        return result;
    }
    public static void initializeList(ArrayList<ArrayList<Integer>> adjList,int n){
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
    }
    public static void createAdjList(ArrayList<ArrayList<Integer>> adjList,int n,int[][] edges){
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
        }
    }
    public static void dfs(int[] startTime,boolean[] onStack,Stack<Integer> stack,List<List<Integer>> result,ArrayList<ArrayList<Integer>> adjList,int[] lowTime,int curr){
        startTime[curr] = time;
        lowTime[curr] = time;
        time++;
        stack.push(curr);
        onStack[curr] = true;
        
        for(Integer x : adjList.get(curr)){
            if(startTime[x]==-1){
                dfs(startTime,onStack,stack,result,adjList,lowTime,x);
            }
            if(onStack[x]){
                lowTime[curr] = Math.min(lowTime[x],lowTime[curr]);
            }
        }
        
        if(startTime[curr]==lowTime[curr]){
            ArrayList<Integer> ssc = new ArrayList<>();
            while(!stack.isEmpty()){
                int x = stack.pop();
                ssc.add(x);
                onStack[x] = false;
                if(x==curr)
                    break;
            }
            result.add(ssc);
        }
        
    }
}












