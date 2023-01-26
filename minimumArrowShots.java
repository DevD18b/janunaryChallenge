import java.util.Arrays;


public class minimumArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0 || points[0].length==0)  return 0;
         int last  = points[0][1];
         int arrow = 1;
 Arrays.sort(points,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

 for(int i =1; i<points.length; i++){
      int current = points[i][0];
      if(current>last){
        arrow++;
      last = points[i][1];
      }
      else{
        last = Math.min(arrow, points[i][1]);
      }
 }
 return arrow;





    }
}
