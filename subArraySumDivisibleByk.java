import java.util.*;
public class subArraySumDivisibleByk {

    public static int subArraySumEqualsK(int [] arr , int k){
     HashMap<Integer,Integer> map = new HashMap<>();

     int sum =0 ;
     int count  =0;
     map.put(0,1 );
     for(int i =0; i<arr.length; i++){
          sum = (sum+arr[i])%k;
          if(map.containsKey(sum)){
            count+=map.get(sum);
          }
          map.put(sum, map.getOrDefault(sum, 0)+1);
     }
       return sum;     
    }
    //
}
