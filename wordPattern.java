import java.util.Objects;
import java.util.*;
class wordPattern{
    public static void main(String[] args) {
        
    }
    public boolean wordPatternProblem(String pattern, String sentence) {
        String[] arrayOfSentence = sentence.split(" ");
        for(String word : arrayOfSentence){
            System.out.print(word +  " ");
        }
        System.out.println();
          // now we are going to map.
          if (pattern.length() != arrayOfSentence.length) return false;
  
          HashMap<String, Integer> map = new HashMap<>();
  
          for (int i = 0; i < pattern.length(); i++) {
              char c = pattern.charAt(i);
              System.out.println(Objects.equals(map.put(c + " ", i), map.put(arrayOfSentence[i], i)));
              if (!Objects.equals(map.put(c + " ", i), map.put(arrayOfSentence[i], i))) {
                  return false;
              }
          }
          return true;   
      }

}