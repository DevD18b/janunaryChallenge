import java.util.ArrayList;
import java.util.*;
class kruskalAlgorithm{
    // it is used to find the minimum spanning tree.
    // it uses the disjointset union data structure to
    // find out the minimum spanning tree.
    // dsu gives us two ideas --> it tell us about how to find the parent.
    // secondly it tells us about the rank.
    // also if two nodes which belongs to same component.
    // have same parent.
    
    public static int minimumSpanningTree(int V , ArrayList<ArrayList<ArrayList<Integer>>> adjList){

      List<edge> graph = new ArrayList<>();

      for(int i =0; i<V; i++){
        for(int j =0; j<adjList.get(i).size(); j++){
            int u =adjList.get(i).get(j).get(0);
        
            int edgeWeight = adjList.get(i).get(j).get(1);
           int node = i;
            edge temp = new edge(u,node,edgeWeight);
            graph.add(temp);
        }
      }

      Collections.sort(graph);
       dsu ds = new dsu(V);
      int mstWeight = 0;
      for(int i =0; i<V; i++){
        int weight = graph.get(i).weight;
        int u = graph.get(i).source;
        int v = graph.get(i).destination;
        

        if(ds.findParent(u)!=ds.findParent(u)){
            mstWeight+=weight;
            ds.unionByRank(u, v);
        }
      }
      return mstWeight;



    }
}
class edge implements Comparable<edge>{
    int source;
    int destination;
    int weight;
    edge(int source , int destination , int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    @Override
    public int compareTo(edge o) {
      
        return this.weight-o.weight;
    }
    
}