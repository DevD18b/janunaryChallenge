import java.util.*;
public class GraphProblemCheapestFlights {

    public static int findTheWaysToReachTheDestinationWithInKSteps(int [][] edges , int k , int source,  int destination){

     ArrayList<ArrayList<Node>> graph =  new ArrayList<>();

     for(int i =0; i<edges.length; i++){
        graph.add(new ArrayList<>());
     }
     for(int [] arr : edges){
        graph.get(arr[0]).add(new Node(arr[1],arr[2]));
     }
    Queue<pair> queue = new LinkedList<>();

    queue.offer(new pair(0, 0,0));
    
    int [] distance = new int[edges.length];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;

    while(!queue.isEmpty()){
         pair p = queue.peek();
         queue.poll();
         int node = p.node;
         int dist = p.distance;
         int steps = p.stops;
         if(steps>=k) continue;
         for(Node neighbour : graph.get(node)){
            int adjNode = neighbour.node;
            int edgeWeight = neighbour.edgeWeight;
            if(edgeWeight+dist<=distance[adjNode]){
                distance[adjNode] = edgeWeight+dist;
                queue.offer(new pair(steps+1,distance[adjNode],adjNode));
            }
         }
    }
    if(distance[destination]==Integer.MAX_VALUE) return -1;
    return distance[destination];
      







    }
}
class Node{
    int node;
    int edgeWeight;
    Node(int node , int edgeWeight){
        this.node= node;
        this.edgeWeight=edgeWeight;
    }

}
class pair{
    int stops;
    int distance;
    int node;
    pair(int stops, int distance , int node){
        this.stops = stops;
        this.distance = distance;
        this.node = node;
    }
}

