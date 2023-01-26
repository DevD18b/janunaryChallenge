import java.util.*;;
public class maxPointsOnLine {
    public static int count(int[][] grid){
  // map to store 
  int max = 0;
  // coordinates heaving same slope.
if(grid.length<=1) return 1;
if(grid.length<=2) return grid.length;

for(int [] points1 :grid){
    HashMap<Integer,Integer> map = new HashMap<>();
      for(int [] points2 : grid){
         if(points1==points2) continue;
          int  slope = 0;
         if(points1[0]==points2[0]){
            slope = Integer.MAX_VALUE;
         }
         else{
            slope = (points2[1]-points1[1])/(points2[0]-points1[0]);
         }
        map.put(slope, map.put(slope, 0)+1);
        if(map.get(slope)>max){
            max =  map.get(slope);
        }

    }
}
return max;
    }
    public static int findSlope(int y1 , int y2 , int x2 , int x1){
        return (y2-y1)/x2-x1;
    }
}
