import java.util.*;
public class subtreeWithSameLabel {


    public static int [] dfs(int source , int parent,  Map<Integer,List<Integer>>map, char [] label , int [] ans){{


        int [] nodeCount  = new int[26];

        nodeCount[label[source]-'a']=1;

        if(!map.containsKey(source)){
            return nodeCount;
        }
        for(int child : map.get(source)){
            if(child==parent) continue;
    
            int [] childCount = dfs(child, source, map, label, ans);

            for(int  i =0; i<26; i++){
                nodeCount[i] += childCount[i];
            }
        }
        ans[source] = nodeCount[label[source]-'a']++;

        return nodeCount;









    }}






    public static int [] countSubTree(int n , int [][] edges , String label){

        Map<Integer,List<Integer>>map = new HashMap<>();

        for(int [] arr : edges){
            int a  = arr[0];
            int b = arr[1];

            map.computeIfAbsent(a, value->new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, value->new ArrayList<Integer>()).add(a);
        
        }

        int [] ans = new int[n];
        char [] lab = new char[label.length()];


        dfs(0,-1,map,lab,ans);

        return ans;








    }
    
}
