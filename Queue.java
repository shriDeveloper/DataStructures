package interview;
import java.util.Arrays;
public class Queue<T extends Comparable<T>> extends Stack implements DSUtility {
    private final Object queue[];
    private int FRONT,REAR;
    private int SIZE;
    public Queue(int N){
        if(N < 0)
            throw new RuntimeException("SIZE CANNOT BE NEGATIVE");
        queue=new Object[N];
        FRONT=-1;
        REAR=-1;
    }
    public Queue(){
        queue=new Object[10];
        FRONT=-1;
        REAR=-1;
        SIZE=10;
    }
    public void insert(T e){
        if(REAR==SIZE-1){
            System.out.println("SOORRY");
        }else{
            super.pushSupportingStack(e);
            queue[++REAR]=e;
        }
    }
    public T delete(){
        if(FRONT==-1)
            FRONT=0;
        return (T)queue[FRONT++];
    }
    public void print(){
        if(FRONT==-1)
            FRONT=0;
        int HEAD=FRONT;
        for(;HEAD<=REAR;HEAD++)
            System.out.print(" "+queue[HEAD]);
    }
    @Override 
    public boolean isFull(){
        return (REAR==SIZE-1);
    }
    @Override
    public boolean isEmpty(){
        return (REAR==-1);
    }
    @Override
    public Object min() {
        return super.min();
    }
    @Override
    public Object max() {
       return super.max();
    }
    @Override
    public void sort() {
        Arrays.sort(queue);
    }
}
