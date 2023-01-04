import java.util.*;
public class implementingDisjointSetUnionDs {
  // implementing union find by rank.
public static void main(String[] args) {
    
}


}
class dsu{
    ArrayList<Integer> parent =  new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();

    dsu(int n){
        for(int i =0 ; i<n; i++){
            parent.add(i);
            rank.add(0);
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

}
