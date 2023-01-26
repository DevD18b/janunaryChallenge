
public class gasStation {
    public static int DriverMethod(int [] gas , int [] cost){
        // iterate over gas and cost array...4
        int sum = 0;
        int total=0;
        int position=0;
        for(int i=0;i<gas.length; i++){
    sum+=gas[i]-cost[i];
    if(sum<0){
        total+=sum;
        sum=0;
        position=i+1;
    }
        }
        total+=sum;
        return total>=0 ? position:-1;
   

    }
}
