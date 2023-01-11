import java.util.*;
public class sameTree {
    public static boolean isSameTree(Node p , Node q){
     Queue<Node>queue1 = new LinkedList<>();
     Queue<Node> queue2 = new LinkedList<>();
      queue1.offer(p);
      queue2.offer(q);
     while(!queue1.isEmpty() && !queue2.isEmpty()){
        Node temp1 = queue1.peek();
        Node temp2 = queue2.peek();
        queue1.poll();
        queue2.poll();

        if(temp1==null &&temp2==null){
            continue;
        }
        if(temp1==null || temp2==null){
            return false;
        }
        if(temp1.data!=temp2.data){
        return false;
        }
        queue1.offer(temp1.left);
        queue1.offer(temp2.left);
        queue2.offer(temp1.right);
        queue2.offer(temp2.right);
     }

     if(queue1.isEmpty() && queue2.isEmpty()) return true;

     return false;


        
    }
    public static boolean isSame(Node root1 , Node root2){
        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();

          ans1 = bfs(root1);
          ans2 =  bfs(root2);

          if(ans1.size()!=ans2.size()){
            return false;
          }
          
          for(int i =0; i<ans1.size(); i++){
            if(ans1.get(i)!=ans2.get(i)) return false;
          }
          return true;
    }
    public static ArrayList<Integer> bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int size  = queue.size();
            while(size-->0){
                Node temp = queue.peek();
                ans.add(temp.data);
                queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return ans;
    }
}
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
