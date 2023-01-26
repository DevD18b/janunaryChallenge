import java.util.*;
public class palindromePartitioning {
    public List<List<String>> partition(String s) {
        List<String> arr = new ArrayList<>();
        List<List<String>>result  = new ArrayList<>();
        dfs(0,s,result,arr);
        return result;
    }
    public static void dfs(int index, String str, List<List<String>> result , List<String> arr){

        if(index >=str.length()){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int i = index; i<str.length(); i++)
        {
            if(isPalindrome(str, index, i)){
            arr.add(str.substring(index,i+1));
            dfs(i+1, str, result, arr);
            arr.remove(arr.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String str , int low , int high){
       
        while(low<high){
        if(str.charAt(low++)!=str.charAt(high--)){
            return false;
        }
        }
        return true;
    }
}
