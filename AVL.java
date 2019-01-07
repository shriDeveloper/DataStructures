package interview;
class AVL{
    private AVLNode ROOT;
    public AVL(){
        ROOT=null;
    }
    private class AVLNode{
        AVLNode left;
        int data;
        AVLNode right;
        int height;
        public AVLNode(int x){
            this.data=x;
            left=right=null;
            height=0;
        }
    }
    public void inorder(){
        inorder(ROOT);
    }
    private void inorder(AVLNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);
        }
    }
   public AVLNode insert(int x,AVLNode root){
       AVLNode node=new AVLNode(x);
       if(root==null){
           root=node;
       }
       else if(x < root.data){
           root.left=insert(x,root.left);
           if(getHeight(root.left)-getHeight(root.right)==2){
               if( x < root.left.data ){
                   root=rotateLeft(root);
               }else{
                   root=rotateLeftRight(root);
               }
           }
       }else if(x > root.data){
            root.right=insert(x,root.right);
            if(getHeight(root.right)-getHeight(root.left)==2){
                if(x > root.right.data){
                    root=rotateRight(root);
                }else{
                    root=rotateRightLeft(root);
                }
            }
            root.height=Math.max(getHeight(root.left),getHeight(root.right))+1;
       }
       return root;
   }
   /**
    * 
    *            50
    *        2          20
    *     1     10   18     30
    * 
    * @param x 
    */
   public void insert(int x){
       ROOT=insert(x,ROOT);
   }
   public AVLNode rotateRightLeft(AVLNode root){
       root.right=rotateLeft(root.right);
       return rotateRight(root);
   }
   public AVLNode rotateLeftRight(AVLNode root){
       root.left=rotateLeft(root.left);
       return rotateLeft(root);
   }
   public AVLNode rotateLeft(AVLNode node){
       AVLNode tmp=node.left;
       node.right=tmp.right;
       tmp.right=node;
       return tmp;
   }
   public AVLNode rotateRight(AVLNode node){
       AVLNode tmp=node.right;
       node.right=tmp.left;
       tmp.left=node;
       return tmp;
   }
    public int getHeight(AVLNode root){
        if(root==null)
            return 0;
        return root.height;
    }
    public static void main(String[] args) {
        AVL avl=new AVL();
        
        avl.insert(50);
        avl.insert(30);
        avl.insert(320);
        avl.insert(32);
        avl.insert(67);
        avl.insert(89);
        //avl.insert(41);
        
        
      //  avl.insert(40);
        
        
        avl.inorder();
    }
}