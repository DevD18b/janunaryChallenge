import java.util.*;

public class NonIncreasingSubseq {
    
    public List<List<Integer>> formOne(int [] arr , int n){

       List<Integer> list = new ArrayList<>();

       helper(arr, n, list);
       
       List<List<Integer>> ans = new ArrayList<>(set);


       return ans;

    }
    static HashSet<List<Integer>> set =  new HashSet<>();
    public static void helper(int [] arr , int index , List<Integer> list){

        // base case
        if(list.size()>=2){
            set.add(new ArrayList<>(list));
            return;
        }
        for(int i =index; i<arr.length; i++){
            if(list.size()==0 || list.get(list.size()-1)>arr[i]){
            list.add(arr[i]);
            helper(arr, i+1, list);
            list.remove(list.size()-1);
            }
        }
    }
}
