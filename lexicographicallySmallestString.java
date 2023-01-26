import java.util.*;
public class lexicographicallySmallestString {
    public static String lexicoGraphicSmallestPossible(String a , String b, String baseString){
       Integer[][] matrix = new Integer[26][26];
       for(int i =0; i<26; i++){
        matrix[a.charAt(i-'a')][b.charAt(i)-'a'] = 1;
        matrix[b.charAt(i)-'a'][a.charAt(i)-'a'] =  1;
       }
       int [] mappingChar = new int[26];

       for(int i =0; i<26; i++){
        mappingChar[i] = i;
       }
       int[] visited = new int[26];
       for(int i =0; i<26; i++)
       {
        if(visited[i]==0){
        List<Integer> component = new ArrayList<>();
        minChar = 27;
        dfs(i, matrix, visited, component);

        for(int j :  component){
              mappingChar[i]= minChar;
        }    
    }
       }
       String ans = "";


       for(char ch : baseString.toCharArray()){
        ans+=(char)(mappingChar[ch-'a']+'a');
       }
       return ans;





    }

    static int minChar ;
    public static void dfs(int source , Integer [][] matrix , int [] visited , List<Integer> component){
        visited[source] = 1;
   
         component.add(source);
    
         minChar = Math.min(minChar, source);
         
         for(int i =0; i<26; i++)
         {
            if(matrix[source][i] != null && visited[i] == 0){
                dfs(i, matrix, visited, component);
            }
         }
    }
    
}
