import java.util.*;
public class longestPathWithDifferentAdjacentCharacter{
    static int ans  = 1;
    public static int findLongest(String str , int [] parent){

     ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();


     int n = parent.length;

     for(int i =0; i<n; i++){
          if(parent[i]!=-1){
            adjList.get(i).add(parent[i]);
            adjList.get(parent[i]).add(i);
          }
     }


     int l =dfs(0, -1, adjList, str);
     return ans;



    }
    public static int dfs(int source , int  parent , ArrayList<ArrayList<Integer>>adjList , String str)
    {
        int max = 0;
        int secondMax =0 ;
        for(int neighbour : adjList.get(source)){
            
            int l = dfs(neighbour, source, adjList , str);
            
             if(neighbour == parent) continue;
            
             if(str.charAt(neighbour)==str.charAt(source)) continue;
              
             if(max<l){
                  secondMax = max;
                  max  = l;
             }
             if(secondMax < l){
                secondMax = l;
             }
        }
        ans = Math.max(max+secondMax+1,ans);
        return max+1;
    }
}
