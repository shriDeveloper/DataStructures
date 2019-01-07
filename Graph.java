package interview;
import java.util.*;
public class Graph {
    private final HashMap<Integer,java.util.LinkedList<Integer>> graph;
    private final boolean IS_DIRECTED;
    private final int SIZE;
    public Graph(int N,boolean IS_DIRECTED){
        if(N < 0)
            throw new RuntimeException("SIZE CANNOT BE NEGATIVE");
        this.IS_DIRECTED=IS_DIRECTED;
        this.SIZE=N;
        graph=new HashMap<>();
        for(int i=1;i<=N;i++)
            graph.put(i,new java.util.LinkedList<>());     
    }
    public void addEdge(int x,int y){
        java.util.LinkedList<Integer> list;
        if(IS_DIRECTED){
            list=graph.get(y);
            list.add(x);
            graph.put(y, list);
        }
        list=graph.get(x);
        list.add(y);
        graph.put(x, list);
    }
    public void DFS(int v){
       Stack<Integer> stack=new Stack<>();
       int visited[]=new int[SIZE];
       stack.push(v);
       visited[v]=1;
       while(!stack.isEmpty()){
           Integer x=stack.pop();
           System.out.print(" "+x);
           for(int y:graph.get(x)){
               if(visited[y]==0){
                   stack.push(y);
                   visited[y]=1;
               }
           }
       }
    }
    public boolean isConnected(){
        Stack<Integer> stack=new Stack<>();
        int visited[]=new int[SIZE];
        stack.push(1);
        while(!stack.isEmpty())
            for(int x:graph.get(stack.pop()))
                if(visited[x]==0)
                    visited[x]=1;
        for(int i=0 ;i< visited.length ; i++)
            if(visited[i]==0)
                return false;
        return false;
    }
    public void BFS(int v){
        java.util.LinkedList<Integer> Queue=new java.util.LinkedList<>();
        boolean visited[]=new boolean[SIZE];
        Queue.add(v);
        visited[v]=true;
        while(Queue.size()!=0){
         int x=Queue.poll();
         System.out.print(x+" ");
         java.util.Iterator<Integer> itr=graph.get(x).iterator();
         while(itr.hasNext()){
             int i=itr.next();
             if(!visited[i]){
                 visited[i]=true;
                 Queue.add(i);
             }
         }
        }  
    }
    public void print(){
        for(Map.Entry<Integer,java.util.LinkedList<Integer>> mapped:graph.entrySet()){
            System.out.print(" "+mapped.getKey()+"->");
            for(int y:mapped.getValue()){
                System.out.print(" "+y);
            }
            System.out.println();
        }
    }
    
}
