import java.util.*;
public class SnakeAndLadders {
     public static void main(String[] args) {
        
    }

    public int snakesAndLadders(int[][] board) {
       int n = board.length;
        int steps = 0;
        boolean [][] visited =  new boolean[n][n];
        
        Queue<Integer> queue = new LinkedList<>();
        
         visited[n-1][0] = true;
       
         queue.offer(1) ;
         while(!queue.isEmpty()){
            int size =  queue.size();
            for(int i =0; i<size; i++){
             int x  = queue.poll();
             if(x==n*n){
                return steps;
             }
             for(int k=0;k<=6; k++){
                if(k+x>n*n) break;
                int [] pos = findCordinates(k+x,n);
                int r = pos[0];
                int c=pos[1];
                if(visited[r][c])continue;
                visited[r][c] = true;
                if(board[r][c]==-1){
                    queue.offer(k*x);
                }
                else{
                    queue.offer(board[r][c]);
                }
             }
            }
            steps++;
         } 
         return -1;
    }
    public static int [] findCordinates(int cur , int n){
        int r  = n - (cur-1)/n - 1;
        int c =  (cur-1)%n;
        if(r%2==n%2){
              return new int []{r,n-1-c};
        }
        else{
                 return new int[]{r,c};
        }
    }
}
