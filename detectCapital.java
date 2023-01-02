public class detectCapital {
    public static  boolean detectCapitalUse(String str) {
        return isAllUpper(str) || isAllLower(str) || firstLetterCap(str);
   }

   public static boolean isAllLower(String word){
       for(int i =0; i<word.length(); i++){
           if(Character.isUpperCase(word.charAt(i))){
               return false;
           }
       }
       return true;
   }
   public static boolean isAllUpper(String word){
       for(int i =0; i<word.length(); i++){
           if(Character.isLowerCase(word.charAt(i))){
               return false;
           }
       }
       return true;
   }
      public static boolean firstLetterCap(String word){
              if(Character.isUpperCase(word.charAt(0))){
           String newString = word.substring(1,word.length());
           return newString.equals(newString.toLowerCase());
          }

      return false;
   }
    public static void main(String[] args) {
    System.out.println(detectCapitalUse("Dev"));
}
}
