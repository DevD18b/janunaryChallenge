public class maxSumCircularSubArray {
    public static int kedanes(int [] arr)
    {
         int minEndingHere = 0;
         int maxSumSoFar = Integer.MIN_VALUE; 
          for(int i =0; i<arr.length; i++){
            minEndingHere+=arr[i];
            if(maxSumSoFar<minEndingHere){
                 maxSumSoFar = minEndingHere;
            }
            if(minEndingHere<0){
                minEndingHere =0 ;
            }

          }
          return maxSumSoFar;
    }
    public static int maxSum(int [] arr){

        int n  = arr.length;
        int contigeousSum = kedanes(arr);
        int y  =0;// total sum - min sum subseq == circularSum
        for(int i =0; i<n; i++){
             y+=arr[i];
             arr[i]*=-1;
        }
        int z = kedanes(arr);
        if(y+z==0) return contigeousSum;
        else 
        return Math.max(y+z, contigeousSum);

    }
    
}
