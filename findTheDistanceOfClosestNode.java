import java.util.Queue;

import javax.management.QueryEval;

import java.util.*;
public class findTheDistanceOfClosestNode {
    

    public static void bfs(int source, int [] edges, int [] distance){
        int n =  edges.length;
       Queue<Integer> queue = new LinkedList<>();
       queue.offer(source);
       boolean [] visited = new boolean[edges.length];
       visited[source] = true;
       queue.offer(source);
       while(!queue.isEmpty()){
        int node = queue.poll();
        if(visited[node]) continue;
        visited[node] =  true;
        int neighbour = edges[node];
        if(neighbour!=-1 && visited[neighbour]==false){
            distance[neighbour]=distance[node]+1;
            queue.offer(neighbour);
        }
       }
    }
    public static int minDistance(int [] edges , int node1, int node2){


        int [] distance1 = new int[edges.length];
        int [] distance2 = new int[edges.length];

         bfs(node1,edges,distance1);
         bfs(node2,edges,distance2);

         int minDistanceNode  = -1;
         int minDistanceTillNow = Integer.MAX_VALUE;

         for(int i =0 ; i<edges.length; i++){
       if(minDistanceTillNow>Math.max(distance1[i],distance2[i])){
          minDistanceNode = i;
        minDistanceTillNow = Math.max(distance1[i],distance2[i]);
            
    }
         }
         return minDistanceNode;










    }
}
