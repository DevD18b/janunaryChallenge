public class maximumIceCreamOneCanBuy {
    public static int maximumIceCream(int [] arr , int coins){
        int index  =0;
        int count  =0;
        while(index<arr.length){
            if(arr[index]<=coins){
                 coins-=arr[index];
                 count++;
            }
        }
        return count;
    }
}
