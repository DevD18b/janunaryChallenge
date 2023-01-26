import java.util.*;
public class minTimeToCollectAllTheApple {
    public static int  minimumTimeToCollect(int [][] edges , int n , List<Boolean> hasApple) 
      {

        List<List<Integer>> graph = new ArrayList<>();
        
        for(int  i =0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] arr : edges){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        boolean [] visited = new boolean[n];

        return dfs(graph, visited, n, hasApple);
        





    }
    public static int dfs(List<List<Integer>> graph , boolean [] visited ,  int source , List<Boolean>hasApple){
              int appleCount = 0;
        visited[source] = true;

        for(int neighbour : graph.get(source)){
            if(!visited[neighbour]){
                appleCount+=dfs(graph, visited, neighbour, hasApple);
            }
        }
        if(source==0){
             return appleCount;
        }
        if(hasApple.get(source) || appleCount>0){
           appleCount+=2;
        }
        return appleCount;
    }
    
}
