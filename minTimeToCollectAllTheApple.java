import java.util.*;
public class minTimeToCollectAllTheApple {
    
    public int minTime(int n, int[][] edges,List<Boolean> hasApple){

HashMap<Integer,List<Integer>> map = new HashMap<>();
for(int i =0;i<n; i++)
{
    int u = edges[i][0];
    int v = edges[i][1];
    map.computeIfAbsent(u, value->new ArrayList<Integer>()).add(v);
    map.computeIfAbsent(v, value->new ArrayList<Integer>()).add(u);
}
return dfs(0,-1,map,hasApple);
}
public static int dfs(int source , int parent , HashMap<Integer,List<Integer>>map,List<Boolean>hasApple){
    if(!map.containsKey(source)) return 0;

int total = 0;
int childTime  = 0;

for(int child : map.get(source)){
    if(child==parent)continue;
    child=dfs(child
        , source, map, hasApple);
        if(child>0 || hasApple.get(child)){
            total+=childTime+2;
        }
}
return total;
} 
}
