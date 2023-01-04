import java.util.*;
public class minimumRoundsToComplete {

public static int minimumRounds(int [] tasks){

HashMap<Integer,Integer> taskMap = new HashMap<>();

for(int i = 0; i<tasks.length; i++){
    taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0)+1);
}
int count = 0;
for(Map.Entry<Integer,Integer> map : taskMap.entrySet()){
    if(map.getValue()==1){
        return -1;
    }
    if(map.getValue()%3==0){
        count+=map.getValue()/3;
    }
    else{
        count+=map.getValue()/3 + 1;
    }
}
return count;

}

    
}
