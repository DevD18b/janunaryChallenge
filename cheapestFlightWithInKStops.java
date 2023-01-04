
import java.util.*;
public class cheapestFlightWithInKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){

        // step 1 build graph.


        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        for(int i =0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] arr  : flights){
            adjList.get(arr[0]).add(new Node(arr[1],arr[2]));
        }

        // step 2 make a queue and follow  standard dijikstras template.

        Queue<pair> queue =  new LinkedList<>();
        queue.offer(new pair(0,src, 0));
        int [] distance =  new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[src] = 0;
        while(!queue.isEmpty()){
           pair p = queue.peek();
        int curNode = p.node;
        int weight = p.distance;
        int stops =p.stops;
        if(stops>=k) continue;
        for(Node nbr : adjList.get(curNode)){
            int adjNode = nbr.adjNode;
            int ew  = nbr.weight;
            if(weight+ew<distance[adjNode]){
                distance[adjNode]=weight+ew;
            }
        }
    }
    if(distance[dst]==(int)1e9) return -1;
    return distance[dst];
}

}
class Node{
    int adjNode;
    int weight;
    Node(int adjNode , int weight){
        this.adjNode = adjNode;
        this.weight = weight;
    }
}
class pair{
    int stops;
    int node;
    int distance;
    pair(int stops , int node , int distance){
        this.stops= stops;
        this.node = node;
        this.distance = distance;
    }
}
