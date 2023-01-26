import java.util.*;

public class RestoreIps {

    public static List<String> validIps(String str){

        List<String> ans = new ArrayList<>();
          List<String> temp = new ArrayList<>();
          validateIps(0, ans, temp, str);
          return ans;
    }
    public static void validateIps(int index , List<String> list, List<String> validIp, String str){

        // base case 
        if(index == str.length() && list.size()==4){
            String validAddress = list.get(0)+'.'+list.get(1)+'.'+list.get(2)+'.'+list.get(3);
            validIp.add(validAddress);
            return;
        }
        String formation = "";
        for(int i =index; i<str.length() && list.size()<4; i++){
            if(str.charAt(i)-'0'>9) continue;
            formation=formation+str.charAt(i);
            int ip = Integer.parseInt(str);
             if(0<=ip && ip<=255){
                   list.add(formation);
                   validateIps(i+1, list, validIp, str);
                   list.remove(list.size()-1);
             }
             if(ip<=0 || ip>255){
                break;
             }
        }








    }
    
}
