import java.util.*;
import java.util.concurrent.ScheduledFuture;
public class ConcatedWord {
    public static List<String> concatenation(String [] arr){
    // since i want unique strings therefore what i am going to do is use a hashset.
         HashSet<String> set = new HashSet<>();
         for(String word : arr){
            set.add(word);
         }
         List<String> list = new ArrayList<>();
         for(String str : arr){
            if(concatedWord(str,set)){
                list.add(str);
            }
         }
         return list;
    }
    public static boolean concatedWord(String word , HashSet<String> set){
        int len = word.length();
        // what are we going to do is we are going to iterate for each and 
        // every single character inside the string.
        for(int i = 1; i<word.length();
         i++){
            String suffixCharacter = word.substring(i);
            if(set.contains(suffixCharacter.substring(0,i)) && set.contains(suffixCharacter) || concatedWord(suffixCharacter, set)){
                   return true;
            }
         }
         return false;
    }
}
