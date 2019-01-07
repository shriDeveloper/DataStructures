package interview;
import java.util.ArrayDeque;
import java.util.TreeMap;
interface BSTUtil<T>{
    void breadthFirstTraversal();
    void depthFirstTraversal();
    int treeDepth();
    void Npreorder(int index);
    void NpostOrder(int index);
    void preorder();
    int countNodes();
    int getLeafCount();
}
public class BinarySearchTree<T extends Comparable> implements BSTUtil {
    private  Node ROOT;
    /**
     * 
     * CODE TO COUNT OCCURENCES OF ELEMENT IN STRING
     * 
     * @param x
     * @return 
     */
    static TreeMap<String,Integer> getOccurences(String x){
        TreeMap<String,Integer> map=new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for(String y:x.split("\\s+")){
            y=y.replaceAll("[^a-zA-Z]","");
            if(map.containsKey(y))
                map.put(y,map.get(y)+1);
            else
                map.put(y,1);
        }
        return map; 
    }
    /**
     * recursively count nodes in left subtree and right subtree
     * 
     * then return 1+ count;
     * 
     * @param root
     * @return 
     */
    private int getNodeCount(Node root){
        if(root==null)
            return 0;
        return 1+(getNodeCount(root.left)+getNodeCount(root.right));
    }
    /**
     * check where root.left==null && root.right==null increment count
     * @param root
     * @return 
     */
   private int getLeafCount(Node root){
       if(root==null)
           return 0;
       if(root.left==null && root.right==null)
           return 1;
       return (getLeafCount(root.left)+getLeafCount(root.right));
   }
    @Override
    public int countNodes(){
        return getNodeCount(ROOT);
    }
    public void sort() {
        print();
    }
    private void preorder(Node root){
        if(root!=null){
                System.out.print(" "+root.e);
                preorder(root.left);
                preorder(root.right);
        }
    }
    @Override
    public void preorder(){
        preorder(ROOT);
    }
    /**
     *  LEVEl order traversal
     * 
     * 1. insert(root) n queue
     * 2. iterate while queue is not empty()
     * 3.remove the node from queue
     * 4.process the node
     * 5.check for left subtree is null if not add to queue(node.left)
     * also do the same for right subtree
     */
    @Override
    public void breadthFirstTraversal() {
        ArrayDeque<Node> dq=new ArrayDeque<>();
        if(ROOT!=null)
            dq.add(ROOT);
        while(!dq.isEmpty()){
            Node t=dq.remove();
            System.out.print(" "+t.e);
            if(t.left!=null)
                dq.add(t.left);
            if(t.right!=null)
                dq.add(t.right);
        }
    }
    @Override
    public void depthFirstTraversal() {
        ArrayDeque<Node> dq=new ArrayDeque<>();
        if(ROOT!=null)
            dq.push(ROOT);
        while(!dq.isEmpty()){
            Node t=dq.pop();
            System.out.print(" "+t.e);
            if(t.left!=null)
                dq.push(t.left);
            if(t.right!=null)
                dq.push(t.right);
        }
    }

    @Override
    public int treeDepth() {
        return getHeight(ROOT);
    }
    private int getHeight(Node root){
        if(root==null)
            return 0;
        else{
            int rDepth=getHeight(root.right);
            int lDepth=getHeight(root.left);
            if(lDepth > rDepth)
                return lDepth+1;
            else
                return rDepth+1;
        }
    }
    private void NpreOrder(Node root,int count,int index){
        if(root!=null){
            count++;
            if(count==index){
                System.out.println(" "+root.e); 
            }
            NpreOrder(root.left,count,index);
            NpreOrder(root.right,count,index);
        }
    }
    @Override
    public void Npreorder(int index) {
        NpreOrder(ROOT,0,index);
    }
    @Override
    public void NpostOrder(int index ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int getLeafCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class Node{
        T e;
        Node left;
        Node right;
        public Node(T x){
            e=x;
            left=right=null;
        }
    }
    public T min(Node root){
        Node trav=root;
        while(trav.left!=null)
            trav=trav.left;
        return trav.e;
    }
    public T max(Node root){
        Node trav=root;
        while(trav.right!=null)
            trav=trav.right;
        return trav.e;
    }
    public BinarySearchTree(){
        ROOT=null;
    }
    public void insert(T e){
        ROOT=insert(e,ROOT);
    }
    /**
     *  if root is null make root as new node
     *  else
     * 
     *  check if value < root.key   then  root.left=insert(root.left,value);
     *  check if value > root.key   then  root.right=insert(root.right,value);
     * @param e
     * @param root
     * @return 
     */
    private Node insert(T e,Node root){
        if(root==null)
            return new Node(e);
        else if(e.compareTo(root.e) <= 0)
            root.left=insert(e,root.left);
        else if(e.compareTo(root.e) > 0 )
            root.right=insert(e,root.right);
        return root;
    }
    public void print(){
       print(ROOT);
    }
    /**
     * 
     * INORDER traversal  ..
     * 
     * LEFT ROOT RIGHT
     * @param root 
     */
    private void print(Node root){
        if(root!=null){
         print(root.left);
         System.out.println(" "+root.e);
         print(root.right);
        }
    }
    public void delete(T x){
       ROOT=delete(x,ROOT);
    }
    /**
     * 
     *  1. SEARCH FOR THE NODE TO BE DELETED
     *  if(FOUND){
     * 
     *  CASE 1:NO CHILD
     *  CASE 2: ONE CHILD
     *  CASE 3: TWO CHILD
     *  
     *   if(2){
     *      update root.left || root.right when possible   
     *   }
     *  if(1){
     *      just root=null would do
     *  }
     *  if(3){
     *      1.FIND MIN IN RIGHT SUBTREE
     *      2. MAKE ROOT.KEY=MIN VALUE
     *      3. DELETE THE ROOT.KEY (i.e) MIN IN RIGHT SUBTREE 
     *   }
     *  }
     * 
     * @param x
     * @param root
     * @return 
     */
    private Node delete(T x,Node root){
        if(root==null) return null;
        else if (x.compareTo(root.e) < 0)    root.left=delete(x,root.left);
        else if (x.compareTo(root.e) > 0 )   root.right=delete(x,root.right);
        else{
            if(root.left==null){
                root=root.left;
            }
            else if(root.right==null){
                root=root.right;
            }else{
                ///find the minimm in right subtree
                root.e=min(root.right);
                root.right=delete(root.e,root.right);
            }
        }
        return root;
    }
}