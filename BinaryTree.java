package interview;
import java.util.ArrayDeque;
class BinaryTree  implements BSTUtil{
    private Node root;
    private int MAX;
    private int MIN;
    BinaryTree(){
        root=null;
        MAX=Integer.MIN_VALUE;
        MIN=Integer.MAX_VALUE;
    }
    public  Node max(){
        return max(root);
    }
    public void delete(int x){
        ArrayDeque<Node> q=new ArrayDeque<>();
        Node node=null;
        q.add(root);
        while(!q.isEmpty()){
            Node t=q.remove();
            if(t.data==x){
                node=last();
                t.data=node.data;
                break;
            }
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);
        }
        q.clear();
        while(!q.isEmpty()){
            Node t=q.remove();
            if(t.left==node){
                t.left=null;
                break;
            }
            if(t.right==node){
                t.right=null;
                break;
            }
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);
        }
        
    }
    public Node last(){
        Node last=null;
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            last=q.remove();
            if(last.left!=null)
                q.add(last.left);
            if(last.right!=null)
                q.add(last.right);
        }
        return last;
    }
    private Node max(Node root){
        Node t,MAX_NODE=null;
        int MAX=Integer.MIN_VALUE;
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
           t=q.remove();
           if(t.data >= MAX){
               MAX=t.data;
               MAX_NODE=t;
           }
           if(t.left!=null)
               q.add(t.left);
           if(t.right!=null)
               q.add(t.right);
        }
        return MAX_NODE;
    }
    /**
     * O(N) 
     * 
     */
    public LinkedList<Node> toList(){
        ArrayDeque<Node> q=new ArrayDeque<>();
        LinkedList<Node> list=new LinkedList<>();
        if(root==null)
            return null;
        q.add(root);
        while(!q.isEmpty()){
            Node t=q.remove();
                list.addLast(t);
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);
        }
        return list;
    }
    @Override
    public void breadthFirstTraversal() {
        BFS();  
    }
    @Override
    public void depthFirstTraversal() {
        DFS();
    }
    @Override
    public int treeDepth() {
        return treeDepth(root);
    }
    private int treeDepth(Node root){
        if(root==null)
            return 0;
        else{
            int lDepth=treeDepth(root.left);
            int rDepth=treeDepth(root.right);
            
            if(lDepth > rDepth)
                return lDepth+1;
            else
               return  rDepth+1;
        }
    }
    @Override
    public void Npreorder(int index) {
        
    }

    @Override
    public void NpostOrder(int index) {
        
    }

    @Override
    public void preorder() {
        
    }
    private int countNodes(Node root){
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    @Override
    public int countNodes() {
        return countNodes(root);
    }
    @Override
    public int getLeafCount() {
        return getLeafCount(root);
    }
    private int getLeafCount(Node root){
        if(root==null)
            return 0;
        if(root.left==null &&  root.right==null)
                return 1;
        else
            return getLeafCount(root.left)+getLeafCount(root.right);
    }
    private class Node{
       Node left;
       int data;
       Node right;
       public Node(int x){
           left=right=null;
           data=x;
       }
       @Override
       public String toString(){
           return ""+data;
       }
   }
   private void inorder(){
       inorder(root);
   }
   private void inorder(Node root){
       if(root!=null){
           inorder(root.left);
           System.out.print(" "+root.data);
           inorder(root.right);
       }
   }
   private void DFS(){
       java.util.Stack<Node> stack=new java.util.Stack<>();
       if(root!=null)
           stack.push(root);
       while(!stack.isEmpty()){
           Node t=stack.pop();
           System.out.print(" "+t.data);
           if(t.left!=null)
               stack.push(t.left);
           if(t.right!=null)
               stack.push(t.right);
       }
   }
   private void BFS(){
       ArrayDeque<Node> q=new ArrayDeque<>();
       if(root!=null)
           q.add(root);
       while(!q.isEmpty()){
          Node t=q.remove();
          System.out.print(" "+t.data);
          if(t.left!=null)
              q.add(t.left);
          if(t.right!=null)
              q.add(t.right);
       }
   }
   public void insert(int x){
       ArrayDeque<Node> q=new ArrayDeque<>();
       if(root==null)
           root=new Node(x);
       else{
           q.add(root);
           while(!q.isEmpty()){
               Node t=q.remove();
               if(t.left==null){
                   t.left=new Node(x);
                   break;  
               }else{
                   q.add(t.left);
               }
               if(t.right==null){
                   t.right=new Node(x);
                   break;
               }else{
                   q.add(t.right);
               }
           }
       }
   }
    public static void main(String[] args) {
        BinaryTree b=new BinaryTree();
        /**
         *              (10)
         *      
         *      (20)             (30)
         *   
         * (40)     (50)    (60)       (70)
         * 
         */
        b.insert(10);  
        b.insert(12);
        b.insert(195);
        b.insert(25);
        b.insert(30);
        b.insert(36);
        System.out.println("MAX: "+b.max());
        b.inorder();
        
        b.delete(12);
        
        
        b.inorder();
        
        
        
        System.out.println("LAST: "+b.last());
    }
}