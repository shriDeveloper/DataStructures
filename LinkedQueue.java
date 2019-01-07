package interview;
public class LinkedQueue<T>{
    private final LinkedList<T> queue;
    LinkedQueue(){
        queue=new LinkedList<>();
    }
    public void insert(T e){
        queue.addLast(e);
    }
    public T delete(){
        return queue.removeFirst();
    }
    public void print(){
        queue.print();
    }
}
