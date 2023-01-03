public class detectColumnsToMakeSorted {
   public static int minDeletionSize(String [] strs){
   
    if(strs.length<=1) return 0;

    int ans = 0;
    for(int col = 0; col<strs[0].length(); col++){
        for(int row = 0; row<strs.length-1; row++){
            if(strs[row+1].charAt(col)<strs[row].charAt(col)){
                ans++;
                break;
            }
        }
    }
    return ans;
    
   } 
}
