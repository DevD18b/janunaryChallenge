import java.util.*;
public class dsu{
    ArrayList<Integer> parent =  new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size =  new ArrayList<>();
    dsu(int n){
        for(int i =0 ; i<n; i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    int findParent(int node){
        if(node==parent.get(node)){
            return parent.get(node);
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }
    void  unionByRank(int u , int v){
        int ulu = findParent(u);
        int ulv = findParent(v);
        if(ulv==ulu) return;
        if(rank.get(ulu)<rank.get(ulv)){
              parent.set(ulu,ulv);
        }
        if(rank.get(ulu)>rank.get(ulv)){
            parent.set(ulv, ulu);
        }
        else{
            parent.set(ulv, ulu);
            int rankU = rank.get(ulu);
            rank.set(ulu, rankU+1);
        }
    }
    void unionBySize(int u ,int v){
         int ulu = findParent(u);
         int ulv = findParent(v);

         if(size.get(ulv)>size.get(ulu)){
            parent.set(ulu, ulv);
            size.set(ulv, size.get(ulv)+size.get(ulu));
         }
         if(size.get(ulu)>size.get(ulv)){
            parent.set(ulv, ulu);
            size.set(ulu, size.get(ulv)+size.get(ulu));
         }
         else{
            return;
         }
    }

}
