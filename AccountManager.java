

import java.util.*;



//User function Template for Java
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
public class AccountManager {
    public static List<List<String>> accoutMerge(List<List<String>> accounts){
        DisjointSet dsu = new DisjointSet(accounts.size());
        HashMap<String,Integer> map = new HashMap<>();

        for(int i =0; i<accounts.size(); i++){
            for(int j =0; j<accounts.get(i).size(); j++){
                 if(!map.containsKey(accounts.get(i).get(j))){
                   map.put(accounts.get(i).get(j), i);
                 }
                 else{
                    dsu.unionBySize(i, map.get(accounts.get(i).get(j)));
                 }
            }
        }
      
        List<String>[] mergeMail = new ArrayList[accounts.size()];
        for(int i =0; i<accounts.size(); i++){
            mergeMail[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer>m : map.entrySet()){
            String mail = m.getKey();
            int node = dsu.findUPar(m.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();

        for(int i =0; i<accounts.size(); i++){
        if(mergeMail[i].size()==0) continue;
        List<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String word : mergeMail[i]){
            temp.add(word);
        }
    ans.add(temp);
        }
        return ans;
    }

    
}

