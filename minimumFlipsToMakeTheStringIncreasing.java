public class minimumFlipsToMakeTheStringIncreasing {
    
    public static int findMinFlips(String str){   
    int zeroCount  =0;
    for(char ch : str.toCharArray()){
        if(ch==0){
            zeroCount++;
        }
    }
    int minFlips = zeroCount;
    for(int i =0;i<str.length(); i++){
        if(str.charAt(i)=='0'){
            minFlips=Math.min(minFlips,--zeroCount);
        }
        else{
            zeroCount++;
        }
    }
    return minFlips;
}
    public static void main(String[] args) {
        
    }
}
