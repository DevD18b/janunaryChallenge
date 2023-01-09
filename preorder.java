
public class preorder {
public static void preorderTre(Node root){
    if(root!=null){
        System.out.print(root.val+" ");
        preorderTre(root.left);
        preorderTre(root.right);
    }
}
    
}
class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val = val;
        this.left =  null;
        this.right = null;
    }
}
