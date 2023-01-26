import java.util.*;

//mport javax.swing.event.ListDataEvent;
public class insertIntervals {

    public static boolean isOverlapping(int[]a , int[] b){
        return Math.min(a[1], b[1])-Math.max(a[0], b[0])>0;
    }
    public static int [] mergeInterval(int []a , int [] b){
        int []  newIntervals={Math.min(a[0], b[0]),Math.max(a[1],b[1])};
        return newIntervals;
    }
    public static int upperBond(int [][] intervals , int [] newIntervals){
       int ans  =0;
        if(intervals.length==0) return 0;

        int start  = 0;
        int end = intervals.length-1;
        while(start<=end){
            int mid= (start+end)/2;
            if(newIntervals[0]<intervals[mid][0]){
                ans =mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    
    public static int [][] insertingIntervals(int [][] intervals,int[]newIntervals){


        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        int index = upperBond(intervals,newIntervals);
        if(index!=intervals.length){
            list.add(index, newIntervals);
        }
        else{
            list.add(newIntervals);
        }

        return list.toArray(new int[list.size()][2]);

    }
    public static int [][]  insert(int[][] intervals, int [] newIntervals){

        List<int[]>list = new ArrayList<>();

        intervals = insertingIntervals(intervals, newIntervals);
        for(int i =0; i<intervals.length; i++)
        {
            int[] currentIntervals = {intervals[i][0],intervals[i][1]};


            if(i<intervals.length && isOverlapping(currentIntervals, newIntervals)){
                currentIntervals = mergeInterval(currentIntervals, newIntervals);
                i++;
            }
            i--;
            list.add(currentIntervals);
        }
        return list.toArray(new int[list.size()][2]);





    }
    
}
