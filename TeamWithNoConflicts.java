import java.util.Arrays;

public class TeamWithNoConflicts {
    // the recursive code for this problem is very much similar to as we write in the LIS problem.
    public static int bestTeamScore(int [] score , int [] ages){
        int n = ages.length;
        int [][] arr = new int[n][2];
        for(int i =0; i<n; i++){
            arr[i][0]= ages[i];
            arr[i][1] = score[i];
        }
        // youngest age and lowest score first.

        Arrays.sort(arr,(a,b)->a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        int [] dp = new int[n];
        for(int i =0; i<n; i++){
            dp[i] = arr[i][1];
        }
        int maxScore = dp[0];
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<i; j++){
                if(arr[j][1]<=arr[i][1]){
                    dp[i] = Math.max(dp[i],arr[i][1]+dp[j]);
                }
            }
            maxScore = Math.max(maxScore,dp[i]);
        }
        return maxScore;
    }

}
