public class numberOfConnectionsToEnhenceTheNetwork {
    
    public static int maxConnection(int n , int [][] connections){
        dsu ds = new dsu(n);
        int component = n;


        for(int i =0; i< connections.length; i++){
            int u = connections[i][0];
            int v  = connections[i][1];
             if(ds.findParent(u)!=ds.findParent(v)){
                if(ds.size.get(ds.findParent(u))<ds.size.get(ds.findParent(v))){
                    ds.parent.set(ds.findParent(u), ds.findParent(v) );
                    ds.size.set(ds.findParent(v),ds.size.get(ds.findParent(u))+ds.size.get(ds.findParent(u)));
                }
                else{
                    ds.parent.set(ds.findParent(v), ds.findParent(u) );
                    ds.size.set(ds.findParent(u),ds.size.get(ds.findParent(v))+ds.size.get(ds.findParent(v)));
                }
                component--;
             } 
        }
        return component-1;



    }
}

