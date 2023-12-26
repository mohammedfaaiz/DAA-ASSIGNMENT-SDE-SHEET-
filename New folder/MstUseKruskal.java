import java.util.*;
public class Solution {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        Collections.sort(graph,(l1,l2)->(l1.get(2)-l2.get(2)));
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        //pass default value
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        //disjoint set
        int weight = 0;
        for(ArrayList<Integer> x : graph){
            if(findParent(x.get(0),rank,parent) != findParent(x.get(1),rank,parent)){
                weight += x.get(2);
                union(x.get(0),x.get(1),rank,parent);
            }
        }
       
        return weight;                      
    }
    public static int findParent(int node,int[] rank,int[] parent){
        if(node==parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node],rank,parent);
        return parent[node];
    } 
    public static void union(int u,int v,int[] rank,int[] parent){
        u = findParent(u,rank,parent);
        v = findParent(v,rank,parent);
        
        if(rank[u]<rank[v]){
            parent[u] = v;
        }
        else if(rank[v]<rank[u]){
            parent[v] = u;
        }
        else{
            parent[v] = u;
            rank[u]++;
        }
    }
    
}











