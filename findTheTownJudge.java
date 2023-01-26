public class findTheTownJudge {
// this is a plane graph problem where town judge is the one who trusts nobody.

public static int findJudge(int [][] trusts){

    int n  = trusts.length;
    int [] inDeg = new int[n+1];
    int [] outDeg = new int[n+1];

    for(int [] arr : trusts){
        ++inDeg[arr[1]];
        ++outDeg[arr[0]];
    }

    for(int i  =1; i<n+1; i++){
        if(inDeg[i]==n-1 && outDeg[i]==0){
            return i;
        }
    }
    return -1;






}
}
